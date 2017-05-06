package com;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by VocaLink on 24/04/2017.
 */
public class WilliamHillStepDefs {

    private Environment         env;
    private boolean             bfootball;
    private boolean             btennis;
    private FootBallTest        footBallTest;

    @Before()
    public void beforeProcessing(){
        WebDriverSingleton singleDriver = WebDriverSingleton.getInstance();
        env = new Environment();
        singleDriver.getDriver().navigate().to(env.getLOCALURL());
    }

    @Given("^I logon to William Hill with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLogonToWilliamHillWithAnd(String arg0, String arg1) throws Throwable {
        LoginTest loginTest = new LoginTest();
        loginTest.logon(arg0,arg1);
    }

    @And("^Navigate to \"([^\"]*)\"$")
    public void navigateTo(String arg0) throws Throwable {
        switch(arg0)
        {
            case "football":
            {
                footBallTest = new FootBallTest();
                footBallTest.navigateToFootball();
                bfootball = true;
                break;
            }
            case "tennis":
            {
                break;
            }
        }
    }

    @When("^I place a bet of \"([^\"]*)\"$")
    public void iPlaceABetOf(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if ( bfootball )
        {
            footBallTest.selectFootballandFirstMatch();
            footBallTest.placebet(arg0);
            // if the balance was not 0 I would click the place bet button here
        }
        else if (btennis){
            // instantiate the TennisTest Helper class here and test (if the user has selected tenis)
        }
    }

    @Then("^I check that \"([^\"]*)\" and resulting balances are correct$")
    public void iCheckThatAndResultingBalancesAreCorrect(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (bfootball)
        {
            Assert.assertTrue(footBallTest.checkAmounts(arg0));
        }
    }

    @After()
    public void afterProcessing(){
       WebDriverSingleton webDriverSingleton = WebDriverSingleton.getInstance();
       webDriverSingleton.getDriver().close();
    }


}
