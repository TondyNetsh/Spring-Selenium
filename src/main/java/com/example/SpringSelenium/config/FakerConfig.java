package com.example.SpringSelenium.config;

import com.example.SpringSelenium.annotation.LazyConfigurations;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@LazyConfigurations
public class FakerConfig {
    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}