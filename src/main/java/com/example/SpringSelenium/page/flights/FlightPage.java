package com.example.SpringSelenium.page.flights;

import com.example.SpringSelenium.kelvin.annotation.Page;
import com.example.SpringSelenium.kelvin.annotation.TakeScreenshot;
import com.example.SpringSelenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {
    @FindBy(css = "a.P4z3kc.KgqTrc")
    private List<WebElement> elements;

    public void goTo(final String url) {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }
    @TakeScreenshot
    public List<String> getLabels() {
        return this.elements.stream().map(e -> e.getText())
                .map(String::trim)
                .collect(Collectors.toList());
    }
    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }
}
