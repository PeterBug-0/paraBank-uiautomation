package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    protected void type(By locator, String text){
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }
    protected String getText(By locator){
        return find(locator).getText();
    }

    protected boolean isDisplayed(By locator){
        try {
            return find(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}