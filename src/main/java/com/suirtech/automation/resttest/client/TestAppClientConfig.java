package com.suirtech.automation.resttest.client;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class TestAppClientConfig {

    @Bean("testAppRestTemplate")
    public RestTemplate restTemplate() {
        RestTemplate rest = new RestTemplate();

        rest.setMessageConverters(Arrays.asList(
                new ResourceHttpMessageConverter(),
                new MappingJackson2HttpMessageConverter(),
                new StringHttpMessageConverter()));

        return rest;
    }


}
