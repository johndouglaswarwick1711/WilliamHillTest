package com;

import com.pages.SportsLandingPage;

/**
 * Created by VocaLink on 28/04/2017.
 */
public class LoginTest {

    private SportsLandingPage page;

    public LoginTest(){}

    public void logon( String username, String password){
        page = new SportsLandingPage(  );
        // button at the top of the page to reveal login panel
        page.clickLoginButton();
        page.setUsername(username);
        page.setPassword(password);
        // final login button
        page.clickLoginFinalButton();
    }
}
