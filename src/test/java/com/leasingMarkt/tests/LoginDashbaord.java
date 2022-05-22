package com.leasingMarkt.tests;


import com.leasingMarkt.pageObjects.CookieAcceptPopup;
import com.leasingMarkt.pageObjects.LandingPage;
import com.leasingMarkt.pageObjects.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class LoginDashbaord extends Base {

    public WebDriver driver;
    // public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("baseurl"));
    }

    @Test(dataProvider = "getData")
    public void loginHuntingPortal(String username, String password) throws InterruptedException {

        CookieAcceptPopup cookieAcceptPopup = new CookieAcceptPopup(driver);
        cookieAcceptPopup.acceptCookies().click();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getKonto().click();
        landingPage.getloginLink().click();
        LoginPage signInPage = new LoginPage(driver);
        signInPage.getUserName().sendKeys(username);
        signInPage.getPassword().sendKeys(password);
        signInPage.getLoginButton().click();
        Thread.sleep(15000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://de-7.leasingmarkt.dev/admin");

    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[1][2];
        data[0][0] = "admin";
        data[0][1] = "admin";

        return data;
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
