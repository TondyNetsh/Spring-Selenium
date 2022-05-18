package com.example.SpringSelenium.googletest;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import com.example.SpringSelenium.page.google.GooglePage;
import com.example.SpringSelenium.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringBaseTestNGTest {
    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenShot();
    }
}
