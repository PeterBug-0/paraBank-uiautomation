package com.automation.tests;


import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class SampleTest extends BaseTest {
    Properties testConfigs = new Properties();

    private LoginPage loginPage;

    // Test Data
    private final String correct_username = testConfigs.getProperty("validUname");
    private final String correct_password= testConfigs.getProperty("validPswd");

    @Test(priority = 1, description = "Verify login is successful")
    public void testSuccessfulLogin(){
        loginPage = new LoginPage(DriverManager.getDriver());
        // Write assertion to verify login is displayed
        loginPage.loginToApp(correct_username,correct_password);

        // wait for dashboard to load then assert it's valid
        Assert.assertFalse(DriverManager.getDriver().getPageSource().contains("Error"), "Error message was found!");

    }

}
