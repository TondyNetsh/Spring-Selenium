package com.example.SpringSelenium.page.window;

import com.example.SpringSelenium.kelvin.annotation.Page;
import com.example.SpringSelenium.kelvin.annotation.Window;
import com.example.SpringSelenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class PageC extends Base {
    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg) {
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }
}
