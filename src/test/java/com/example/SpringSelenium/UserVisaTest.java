package com.example.SpringSelenium;

import com.example.SpringSelenium.entity.User;
import com.example.SpringSelenium.page.visa.VisaRegistrationPage;
import com.example.SpringSelenium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {
    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test
    public void visaTest() {
        System.out.println(this.repository.findAll().size());
        this.repository.findById(85).ifPresent(u -> System.out.println(u.getFirstName()));
        List<User> users = this.repository.findAll().stream().limit(3).collect(Collectors.toList());

        for(User u : users) {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setFromCountryFromAndTo(u.getFromCountry(),u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(),u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            System.out.println(this.registrationPage.getConfirmationNumber());
        }
    }
}
