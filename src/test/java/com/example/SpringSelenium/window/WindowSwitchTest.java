package com.example.SpringSelenium.window;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import com.example.SpringSelenium.kelvin.service.WindowSwitchService;
import com.example.SpringSelenium.page.window.MainPage;
import com.example.SpringSelenium.page.window.PageA;
import com.example.SpringSelenium.page.window.PageB;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SpringBaseTestNGTest {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeClass
    public void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchTest() {
        this.switchService.switchByTitle("Page A");
        this.pageA.addToArea("Hi page A");
        this.switchService.switchByIndex(2);
        this.pageA.addToArea("Hello Page B");
    }
}
