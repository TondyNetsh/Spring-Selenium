package com.example.SpringSelenium.bdd;

import io.cucumber.java.en.*;

public class GoogleSteps {
    @Given("^I am on the google site$")
    public void i_am_on_the_google_site() throws Throwable {
        //throw new PendingException();
    }

    @When("^I enter \"([^\"]*)\" as a keyword$")
    public void i_enter_something_as_a_keyword(String keyword, String strArg1) throws Throwable {
        //throw new PendingException();
    }

    @Then("^I should see at least \"([^\"]*)\" results$")
    public void i_should_see_at_least_something_results(String resultcount, String strArg1) throws Throwable {
        //throw new PendingException();
    }

    @And("^I click on the search button$")
    public void i_click_on_the_search_button() throws Throwable {
        //throw new PendingException();
    }
}
