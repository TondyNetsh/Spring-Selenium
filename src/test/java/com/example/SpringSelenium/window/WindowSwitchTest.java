package com.example.SpringSelenium.window;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import com.example.SpringSelenium.kelvin.service.WindowSwitchService;
import com.example.SpringSelenium.page.window.MainPage;
import com.example.SpringSelenium.page.window.PageA;
import com.example.SpringSelenium.page.window.PageB;
import com.example.SpringSelenium.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=firefox")
public class WindowSwitchTest extends SpringBaseTestNGTest {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeClass
    public void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchTest() throws InterruptedException {
        this.switchService.switchByTitle("Page A");
        Thread.sleep(3000);
        this.pageA.addToArea("Welcome to Page A");
        Thread.sleep(3000);
        this.switchService.switchByIndex(2);
        Thread.sleep(3000);
        this.pageA.addToArea("This is Page B");
        Thread.sleep(3000);
        this.switchService.switchByTitle("Page C");
        Thread.sleep(3000);
        this.pageC.addToArea("The third Page C");
    }
}
