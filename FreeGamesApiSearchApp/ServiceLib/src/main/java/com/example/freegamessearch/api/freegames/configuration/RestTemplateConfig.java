package com.example.freegamessearch.api.freegames.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
import java.net.http.HttpHeaders;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Scope("prototype")
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
