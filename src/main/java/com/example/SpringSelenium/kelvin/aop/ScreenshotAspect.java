package com.example.SpringSelenium.kelvin.aop;

import com.example.SpringSelenium.kelvin.annotation.TakeScreenshot;
import com.example.SpringSelenium.kelvin.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {
    @Autowired
    private ScreenshotService screenshotAspectService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotAspectService.takeScreenShot();
    }
}
