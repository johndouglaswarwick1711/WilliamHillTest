package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VocaLink on 25/04/2017.
 */
public class WebDriverSingleton {
    private WebDriver webDriver;

    private static WebDriverSingleton ourInstance = new WebDriverSingleton();

    public static WebDriverSingleton getInstance() {
        return ourInstance;
    }

    public WebDriver getDriver() { return webDriver; }

    private WebDriverSingleton() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VocaLink\\Downloads\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
}
