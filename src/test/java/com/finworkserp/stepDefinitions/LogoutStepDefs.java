package com.finworkserp.stepDefinitions;

import com.finworkserp.pages.LoginPage;
import com.finworkserp.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogoutStepDefs {
    @Then("the user should able to logout")
    public void the_user_should_able_to_logout() {
        LoginPage loginPage = new LoginPage();
        loginPage.logOut();
        System.out.println("Expected Title = " + Driver.get().getTitle());
        Assert.assertTrue("Logout function doesn't work properly, please check", Driver.get().getTitle().equals("Login | Best solution for startups"));
    }
}
