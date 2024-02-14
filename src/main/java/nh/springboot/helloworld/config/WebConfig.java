package nh.springboot.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nh.springboot.helloworld.interceptor.AppContextInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createLogHandlerInterceptor());
    }
    
    @Bean
    public AppContextInterceptor createLogHandlerInterceptor() {
        return new AppContextInterceptor();
    }
}