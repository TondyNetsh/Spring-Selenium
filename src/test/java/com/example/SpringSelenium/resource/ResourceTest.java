package com.example.SpringSelenium.resource;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class ResourceTest extends SpringBaseTestNGTest {
    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
    }
}
