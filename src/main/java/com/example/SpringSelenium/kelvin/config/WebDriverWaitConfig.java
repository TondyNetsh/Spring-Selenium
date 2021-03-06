package com.example.SpringSelenium.kelvin.config;

import com.example.SpringSelenium.kelvin.annotation.LazyConfigurations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@LazyConfigurations
public class WebDriverWaitConfig {
    @Value("${default.timeout:30}")
    private int timeout;

    //@Scope("prototype")
    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        return new WebDriverWait(driver, this.timeout);
    }
}
