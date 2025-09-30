package com.automation.utils;

import java.util.Properties;

public class ConfigManager {
    private static Properties config;
    private static Properties locators;
    private static Properties testData;

    // Load all properties once when class is loaded
    static {
        config = ConfigReader.loadProperties("src/test/resources/config.properties");
        locators = ConfigReader.loadProperties("src/test/resources/locators.properties");
        testData = ConfigReader.loadProperties("src/test/resources/testdata.properties");
    }

    // Get config properties (like URLs, browser, timeouts)
    public static String getConfigProperty(String key) {
        return config.getProperty(key);
    }

    // Get locator properties (element IDs, XPaths, etc.)
    public static String getLocator(String key) {
        return locators.getProperty(key);
    }

    // Get test data properties
    public static String getTestData(String key) {
        return testData.getProperty(key);
    }
}