package com.gmail.shelkovich.anton.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterChain;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {


        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter(){
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                super.doFilterInternal(request, response, filterChain);
            }
        };

        FilterRegistration encodingFilterReg = servletContext.addFilter("encodingFilter", encodingFilter);
        encodingFilterReg.setInitParameter("encoding", "UTF-8");
        encodingFilterReg.setInitParameter("forceEncoding", "true");
        encodingFilterReg.addMappingForUrlPatterns(null, false, "/*");

        super.onStartup(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
