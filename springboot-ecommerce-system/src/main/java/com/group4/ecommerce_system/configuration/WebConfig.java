package com.group4.ecommerce_system.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**")
	                .addResourceLocations("classpath:/static/images/");
	    }
}

//Interface
//WebMvcConfigurer:
//This is an interface provided by Spring Web MVC.
//It allows customizing the configuration for Spring MVC, 
//providing default implementations for all its methods so you can override only the ones you need.
//By implementing WebMvcConfigurer, you can configure things like resource handlers, 
//view controllers, and other aspects of the Spring MVC setup.


//registry.addResourceHandler("/images/**"):
//
//This method call adds a resource handler for serving static resources.
//addResourceHandler("/images/**"): This specifies the URL pattern for accessing static resources. The /** means any sub-path after /images.
//When a request URL matches this pattern, Spring will look for the resources in the locations specified in addResourceLocations.
//addResourceLocations("classpath:/static/images/"):
//
//This method call specifies the locations where Spring will search for the resources.
//classpath:/static/images/: This indicates that the resources are located in the static/images directory inside the classpath (typically src/main/resources/static/images).