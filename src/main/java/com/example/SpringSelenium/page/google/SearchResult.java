package com.example.SpringSelenium.page.google;

import com.example.SpringSelenium.kelvin.annotation.PageFragment;
import com.example.SpringSelenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends Base {
    @FindBy(css = "div.jtfYYd")
    private List<WebElement> results;

    public int getCount() {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }
}