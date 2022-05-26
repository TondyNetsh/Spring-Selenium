package com.example.SpringSelenium.flights;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("language/en.properties")
public class FlightAppDetails {
    @Value("${flight.app.url}")
    private String url;

    @Value("${flight.app.label}")
    private List<String> labels;

    public String getUrl() {
        return url;
    }

    public List<String> getLabels() {
        return labels;
    }
}
