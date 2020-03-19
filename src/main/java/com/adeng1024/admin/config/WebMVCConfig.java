package com.adeng1024.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig  implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/crud").setViewName("crud");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/icon").setViewName("icon");
        registry.addViewController("/panel").setViewName("panel");
        registry.addViewController("/animate").setViewName("animate");
        registry.addViewController("/table").setViewName("table");
//        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/employee/add").setViewName("employee-add");
        registry.addViewController("/user/add").setViewName("user-add");
        registry.addViewController("/404").setViewName("/error/404");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**")
                .excludePathPatterns( "/toLogin","/login", "/layui/**", "/image/**","/css/**");
    }
}
