package com.example.project.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:/usr/local/fengqihang/static/img/");
        //  ApplicationHome h = new ApplicationHome(this.getClass());
        //String path= h.getSource().getParent();
        // String realPath=path+"/static/img";
        // registry.addResourceHandler("/static/img/**").addResourceLocations("file:" + realPath);

    }
}