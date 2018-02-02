package com.gmail.shelkovich.anton.config.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final Logger logger = Logger.getLogger(CustomSuccessHandler.class);

    private RequestCache requestCache = new HttpSessionRequestCache();

    {
        super.setRequestCache(requestCache);
    }

    @Override
    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
        super.setRequestCache(requestCache);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws ServletException, IOException {
        SavedRequest savedRequest = requestCache.getRequest(req, resp);

        if (savedRequest == null) {
            Object referURI = req.getSession().getAttribute("referURI");
            if (referURI != null) {
                logger.info("ReferURI = " + referURI);
                if (referURI.toString().contains("/login") || referURI.toString().contains("/reg")) {
                    resp.sendRedirect(req.getContextPath());
                } else {
                    resp.sendRedirect(referURI.toString());
                }
            }
        } else {
            super.onAuthenticationSuccess(req, resp, authentication);
        }


    }


}
