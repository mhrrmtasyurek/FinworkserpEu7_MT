package com.finworkserp.stepDefinitions;

import com.finworkserp.pages.LoginPage;
import com.finworkserp.utilities.BrowserUtils;
import com.finworkserp.utilities.ConfigurationReader;
import com.finworkserp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enters the valid {string} information")
    public void the_user_enters_the_valid_information(String user) {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @When("the user enters the invalid_empty {string} or {string}")
    public void the_user_enters_the_invalid_empty_or(String userName, String passWord) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, passWord);
    }
    @Then("the user should get error message {string}")
    public void the_user_should_get_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,new LoginPage().error_message.getText().trim());
    }

    @Then("the user should able to get title {string}")
    public void theUserShouldAbleToGetTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());

    }

    @Then("the user should get caution message {string}")
    public void theUserShouldGetCautionMessage(String expectedMessage) {

        if(expectedMessage.equals(Boolean.parseBoolean(new LoginPage().userName.getAttribute("required")))){
        Assert.assertEquals(expectedMessage,new LoginPage().userName.getAttribute("validationMessage"));}
        Assert.assertEquals(expectedMessage,new LoginPage().password.getAttribute("validationMessage"));

    }
}
