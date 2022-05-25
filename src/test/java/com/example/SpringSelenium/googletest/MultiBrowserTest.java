package com.example.SpringSelenium.googletest;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MultiBrowserTest extends SpringBaseTestNGTest {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private WebDriver chromeDriver;

    @Autowired
    private WebDriver firefoxDriver;

    @Test
    public void browserTest() {
        //chromeDriver.get("https://www.tut.ac.za");
        this.context.getBean("chromeDriver", WebDriver.class).get("https://www.tut.ac.za");
        this.context.getBean("firefoxDriver", WebDriver.class).get("https://www.google.co.za");
        //firefoxDriver.get("https://www.tut.ac.za");
    }
}
