package com.example.SpringSelenium.config;

import com.example.SpringSelenium.annotation.LazyConfigurations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@LazyConfigurations
public class WebDriverWaitConfig {
    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @Scope("prototype")
    public WebDriverWait webDriverWait(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        return new WebDriverWait(driver, this.timeout);
    }
}
