package com;

import com.pages.FootballPage;
import com.pages.SportsLandingPage;
import org.junit.Assert;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by VocaLink on 28/04/2017.
 */
public class FootBallTest {
    private FootballPage    page;
    private Double          currrentBalance;
    private Double          runningTotal;
    private Double          odds_total;

    public FootBallTest(){
         page = new FootballPage();
    }

    public void selectFootballandFirstMatch(){
        page.selectFirstMatch();
    }

    public void placebet( String amount ){
        page.placebetAmount(amount);
        page.clickPlaceBet();
    }

    public void navigateToFootball(){
        page.clickonFootballButton();
    }

    public boolean checkAmounts( String placedAmount )
    {
        Double betPlaced = Double.valueOf(placedAmount);
        Double bettoReuturn = page.getBettoReuturn();
        currrentBalance = page.getCurrentBalance();
        runningTotal = currrentBalance - betPlaced;
        Double checkOddsTotal = page.getOdds_fractionToDecimalValue() * betPlaced;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);

        // check that the odds displayed on the site equal our calculated odds
        if (Double.valueOf(df.format(checkOddsTotal)).equals(bettoReuturn))
            return true;
        else
            return false;
    }
}
