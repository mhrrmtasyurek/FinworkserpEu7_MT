package com.finworkserp.pages;

import com.finworkserp.utilities.BrowserUtils;
import com.finworkserp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "login")
    public WebElement userName;

    @FindBy(id ="password")
    public WebElement password;

    @FindBy(css =".btn-primary")
    public WebElement logIn;

    @FindBy(tagName = "p")
    public WebElement error_message;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        logIn.click();
}
    }