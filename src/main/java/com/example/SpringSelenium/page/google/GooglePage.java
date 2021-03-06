package com.example.SpringSelenium.page.google;

import com.example.SpringSelenium.kelvin.annotation.Page;
import com.example.SpringSelenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {
    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo() {
        this.driver.navigate().to(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close() {
        this.driver.quit();
    }
}