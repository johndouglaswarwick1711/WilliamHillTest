package com.pages;

import com.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by VocaLink on 27/04/2017.
 */
public class FootballPage {
    private String      odds;
    private Double      odds_fractionToDecimalValue;

    public FootballPage(){
    }

    public void clickonFootballButton(){
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-football > i")));
        WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#nav-football > i")).click();
    }

    public String getOdds(){
        return odds;
    }

    public void selectFirstMatch(){
        int numerator  =0;
        int deominator =0;
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btmarket__selection")));
        List<WebElement> betbutton__odds = WebDriverSingleton.getInstance().getDriver().findElements(By.className("btmarket__selection"));
        String[] split = betbutton__odds.get(0).getText().split("/");
        numerator = Integer.parseInt(split[0]);
        deominator= Integer.parseInt(split[1]);
        // work out the odds
        odds_fractionToDecimalValue = (double)numerator / deominator;
        odds_fractionToDecimalValue = odds_fractionToDecimalValue +1;
        betbutton__odds.get(0).click();
    }

    public Double getOdds_fractionToDecimalValue()
    {
        return odds_fractionToDecimalValue;
    }

    public void placebetAmount(String amount) {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("betslip-selection__stake-input")));
        List<WebElement> betbutton__placeamount = WebDriverSingleton.getInstance().getDriver().findElements(By.className("betslip-selection__stake-input"));
        betbutton__placeamount.get(0).sendKeys(amount);
    }

    public void clickPlaceBet(){
       // WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#place-bet-button")));
       // WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#place-bet-button")).click();
    }

    public Double getCurrentBalance(){
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBalance")));
        String strAmount = WebDriverSingleton.getInstance().getDriver().findElement(By.cssSelector("#userBalance")).getText().substring(1);
        return Double.valueOf(strAmount);
    }

    public Double getBettoReuturn()
    {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-to-return-price")));
        return Double.valueOf(WebDriverSingleton.getInstance().getDriver().findElement(By.id("total-to-return-price")).getText().substring(1));
    }

    public Double getTotalStake(){
        //total-stake-price
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-stake-price")));
        return Double.valueOf(WebDriverSingleton.getInstance().getDriver().findElement(By.id("total-stake-price")).getText().substring(1));
    }

}
