package au.com.mqas.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MqasWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/static/**").addResourceLocations("/resources/", "/webjars/");
    }
    
    
    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate = new RestTemplate();
    	return restTemplate;
    }

}
