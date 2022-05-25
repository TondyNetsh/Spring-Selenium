package com.example.SpringSelenium.kelvin.config;

import com.example.SpringSelenium.kelvin.annotation.LazyConfigurations;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfigurations
public class FakerConfig {
    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}