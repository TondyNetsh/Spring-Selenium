package com.example.SpringSelenium.googletest;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import com.example.SpringSelenium.page.google.GooglePage;
import com.example.SpringSelenium.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class Google2Test extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotService screenShotService;

    @Test
    public void googleTest() throws IOException, InterruptedException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        //Thread.sleep(5000);
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotService.takeScreenShot();
        this.googlePage.close();
    }
}