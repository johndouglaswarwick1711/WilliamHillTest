package com.pages;

import com.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VocaLink on 24/04/2017.
 */
public class SportsLandingPage {

public SportsLandingPage(){
}

public void setUsername( String username ){
    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginUsernameInput")));
    WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#loginUsernameInput")).sendKeys( username );
}

public void setPassword( String password ){
    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginPasswordInput")));
    WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#loginPasswordInput")).sendKeys( password );
}

public void clickLoginButton (){
    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.account-tab__text:nth-child(4) > span:nth-child(1)")));
    WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("span.account-tab__text:nth-child(4) > span:nth-child(1)")).click();
}

public void clickLoginFinalButton(){
    WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#loginButton")).click();
}
}
