package com.gmail.shelkovich.anton.web.config;

import org.apache.tomcat.util.descriptor.web.JspConfigDescriptorImpl;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroup;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroupDescriptorImpl;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;
import javax.servlet.descriptor.TaglibDescriptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {


        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter(){
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                response.setContentType("text/html; charset=UTF-8");
                System.out.println("\n\n\nUTF-8!!!\n\n\n\n");
                super.doFilterInternal(request, response, filterChain);
            }
        };

        //FilterRegistration.Dynamic ?
        FilterRegistration encodingFilterReg = servletContext.addFilter("encodingFilter", encodingFilter);
        encodingFilterReg.setInitParameter("encoding", "UTF-8");
        encodingFilterReg.setInitParameter("forceEncoding", "true");
        //encodingFilterReg.addMappingForUrlPatterns(null, false, "/*");

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
