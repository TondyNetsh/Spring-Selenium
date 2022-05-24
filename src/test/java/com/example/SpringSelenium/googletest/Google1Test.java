package com.example.SpringSelenium.googletest;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import com.example.SpringSelenium.page.google.GooglePage;
import com.example.SpringSelenium.util.ScreenShotUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Google1Test extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException, InterruptedException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        //Thread.sleep(5000);
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenShot();
    }
}