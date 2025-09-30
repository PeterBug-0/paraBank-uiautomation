package com.automation.pages;

import com.automation.base.BasePage;
import com.automation.utils.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    // Declare Register page elements using ConfigManager
    private final By registerLink;
    private final By firstNameField;
    private final By lastNameField;
    private final By addressField;
    private final By cityField;
    private final By stateField;
    private final By zipCodeField;
    private final By phoneField;
    private final By ssnField;
    private final By usernameField;
    private final By passwordField;
    private final By confirmPasswordField;
    private final By registerButton;

    // Constructor - Initialize all locators
    public RegisterPage(WebDriver driver) {
        super(driver);

        // Load locators from ConfigManager
        registerLink = By.linkText(ConfigManager.getLocator("register.link"));
        firstNameField = By.id(ConfigManager.getLocator("register.firstname.id"));
        lastNameField = By.id(ConfigManager.getLocator("register.lastname.id"));
        addressField = By.id(ConfigManager.getLocator("register.address.id"));
        cityField = By.id(ConfigManager.getLocator("register.city.id"));
        stateField = By.id(ConfigManager.getLocator("register.state.id"));
        zipCodeField = By.id(ConfigManager.getLocator("register.zipcode.id"));
        phoneField = By.id(ConfigManager.getLocator("register.phone.id"));
        ssnField = By.id(ConfigManager.getLocator("register.ssn.id"));
        usernameField = By.id(ConfigManager.getLocator("register.username.id"));
        passwordField = By.id(ConfigManager.getLocator("register.password.id"));
        confirmPasswordField = By.id(ConfigManager.getLocator("register.confirm.id"));
        registerButton = By.xpath(ConfigManager.getLocator("register.button.xpath"));
    }

    // Page Actions
    public void clickRegisterLink() {
        click(registerLink);
    }

    public void enterFirstName(String firstname) {
        type(firstNameField, firstname);
    }

    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    public void enterAddress(String address) {
        type(addressField, address);
    }

    public void enterCity(String city) {
        type(cityField, city);
    }

    public void enterState(String state) {
        type(stateField, state);
    }

    public void enterZipCode(String zipcode) {
        type(zipCodeField, zipcode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        type(phoneField, phoneNumber);
    }

    public void enterSSN(String ssn) {
        type(ssnField, ssn);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void enterConfirmPassword(String confirm) {
        type(confirmPasswordField, confirm);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    // Complete registration flow
    public void registerUser(String firstname, String lastname, String address,
                             String city, String state, String zipcode,
                             String phonenumber, String ssn, String username,
                             String password, String confirm) {
        clickRegisterLink();
        enterFirstName(firstname);
        enterLastName(lastname);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterZipCode(zipcode);
        enterPhoneNumber(phonenumber);
        enterSSN(ssn);
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(confirm);
        clickRegisterButton();
    }

    // Overloaded method to register using default test data
    public void registerWithDefaultData() {
        registerUser(
                ConfigManager.getTestData("firstname"),
                ConfigManager.getTestData("lastname"),
                ConfigManager.getTestData("address"),
                ConfigManager.getTestData("city"),
                ConfigManager.getTestData("state"),
                ConfigManager.getTestData("zipcode"),
                ConfigManager.getTestData("phone"),
                ConfigManager.getTestData("ssn"),
                ConfigManager.getTestData("username"),
                ConfigManager.getTestData("password"),
                ConfigManager.getTestData("correct-confirm")
        );
    }
}