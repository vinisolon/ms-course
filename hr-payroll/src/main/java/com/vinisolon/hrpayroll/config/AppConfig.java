package com.vinisolon.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Singleton do obj rest template
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
