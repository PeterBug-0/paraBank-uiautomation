package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.RegisterPage;
import com.automation.utils.ConfigManager;
import com.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private RegisterPage registerPage;

    @Test(priority = 1, description = "Verify successful registration with test data")
    public void testSuccessfulRegister() {
        // Navigate to application
        DriverManager.getDriver().get(ConfigManager.getConfigProperty("base-url"));

        // Initialize page
        registerPage = new RegisterPage(DriverManager.getDriver());

        // Perform registration with data from properties
        registerPage.registerUser(
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

        // Assertions
        Assert.assertTrue(
                DriverManager.getDriver().getPageSource().contains("successfully") ||
                        DriverManager.getDriver().getCurrentUrl().contains("overview"),
                "Registration was not successful!"
        );
    }

    @Test(priority = 2, description = "Verify registration with default data method")
    public void testRegisterWithDefaultData() {
        DriverManager.getDriver().get(ConfigManager.getConfigProperty("base.url"));

        registerPage = new RegisterPage(DriverManager.getDriver());
        registerPage.registerWithDefaultData();

        // Assertions
        Assert.assertFalse(
                DriverManager.getDriver().getPageSource().contains("Error"),
                "Error message was found during registration!"
        );
    }

    @Test(priority = 3, description = "Verify registration with custom data")
    public void testRegisterWithCustomData() {
        DriverManager.getDriver().get(ConfigManager.getConfigProperty("base.url"));

        registerPage = new RegisterPage(DriverManager.getDriver());

        // Use custom data instead of properties
        registerPage.registerUser(
                "Jane",
                "Smith",
                "456 Oak Avenue",
                "Los Angeles",
                "CA",
                "90001",
                "555-5678",
                "987-65-4321",
                "janesmith" + System.currentTimeMillis(), // Unique username
                "SecurePass@456",
                "SecurePass@456"
        );

        // Assertions
        Assert.assertTrue(
                DriverManager.getDriver().getCurrentUrl().contains("overview"),
                "Registration failed with custom data!"
        );
    }
}