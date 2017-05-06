package com.pages;

import com.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VocaLink on 27/04/2017.
 */
public class TennisPage {

    public TennisPage(){

    }

    public void clickTennisMenuOption(){
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-tennis > a")));
        WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#nav-tennis > a")).click();
    }

    public void selectFirstMatch(){
    }
}
