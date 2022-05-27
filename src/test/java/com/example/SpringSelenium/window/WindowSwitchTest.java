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
import org.testng.annotations.DataProvider;
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


    @BeforeClass
    public void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index) {
        this.pageA.addToArea(index + "\n");
        this.pageB.addToArea((index * 2) + "\n");
        this.pageC.addToArea((index * 3) + "\n");
    }

    @DataProvider()
    public Object[] getData() {
        return new Object[] { 3, 4, 1, 5, 6, 2 };
    }
}
