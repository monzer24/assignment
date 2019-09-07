package com.student;

import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.faces.webapp.FacesServlet;
import java.util.EnumSet;

@EnableAutoConfiguration
@ComponentScan({"com.student.controller", "com.student.data", "com.student.pojo"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new FacesServlet(), "*.jsf");
        registrationBean.addUrlMappings("*.xhtml");
        registrationBean.addUrlMappings("/student/*");
        registrationBean.addUrlMappings("/list/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<RewriteFilter> filterRegistrationBean(){
        FilterRegistrationBean<RewriteFilter> rwFilter = new FilterRegistrationBean<>(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }

}
