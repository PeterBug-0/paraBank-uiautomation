package com.automation.base;

import com.automation.pages.LoginPage;
import com.automation.pages.RegisterPage;
import com.automation.utils.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.Properties;

public class BaseTest {
    Properties testsConfigs = ConfigReader.loadProperties(System.getProperty("user.dir") + "/src/test/resources/config.properties");
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected final String BASE_URL = testsConfigs.getProperty("base-url");
    protected WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome")String browser){
        System.out.println("Setting up test with browser: "  + browser);
        DriverManager.setDriver(browser);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
    }

//    @BeforeMethod
//    public void loadSite(){
//        //Navigate to the login page from which other tests will start from
//        DriverManager.getDriver().get(BASE_URL);
//        registerPage = new RegisterPage(DriverManager.getDriver());
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        System.out.println("Cleaning up tests...");
        DriverManager.quitDriver();
    }
}
