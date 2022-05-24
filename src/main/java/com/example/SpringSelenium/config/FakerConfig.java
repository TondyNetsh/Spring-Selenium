package com.example.SpringSelenium.config;

import com.github.javafaker.Faker;
import com.example.SpringSelenium.annotation.LazyConfigurations;
import org.springframework.context.annotation.Bean;

@LazyConfigurations
public class FakerConfig {
    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}