package com.example.demoswagger;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zenglw
 * @date 2018/7/2
 */

@Component
public class SwaggerResourceAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/static/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/static/js/**").addResourceLocations("/js/");
        registry.
                addResourceHandler("/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.
                addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
