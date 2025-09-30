package com.automation.pages;

import com.automation.base.BasePage;
import com.automation.utils.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameField;
    private final By passwordField;
    private final By loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        usernameField = By.name(ConfigManager.getLocator("login.username.name"));
        passwordField = By.name(ConfigManager.getLocator("login.password.name"));
        loginButton = By.xpath(ConfigManager.getLocator("login.button.xpath"));
    }

    public void loginToApp(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
}