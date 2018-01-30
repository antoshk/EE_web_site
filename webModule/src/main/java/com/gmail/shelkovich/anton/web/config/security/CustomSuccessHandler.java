package com.gmail.shelkovich.anton.web.config.security;

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
            Object referUrl = req.getSession().getAttribute("referURI");
            if (referUrl != null) {
                resp.sendRedirect(referUrl.toString());
            }
        } else {
            super.onAuthenticationSuccess(req, resp, authentication);
        }


    }


}
