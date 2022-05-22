package com.leasingMarkt.tests;

import com.leasingMarkt.pageObjects.CookieAcceptPopup;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class ValidateTitle extends Base {
	
	public WebDriver driver;
	// public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		// log.info("driver is initialized");
		driver.get(prop.getProperty("baseurl"));
		// log.info("Navigate to Homepage");
	}

	@Test
	public void loginValidation() {
		
		CookieAcceptPopup cookieAccept = new CookieAcceptPopup(driver);
		cookieAccept.acceptCookies().click();
		String titleUrl = driver.getCurrentUrl();
		Assert.assertEquals(titleUrl, "https://de-7.leasingmarkt.dev/");
		// log.info("Successfully sees leasing markt Website");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
