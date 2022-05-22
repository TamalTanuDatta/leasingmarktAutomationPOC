package com.leasingMarkt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieAcceptPopup {

	public WebDriver driver;

	private By acceptCookies = By.linkText("OK");

	public CookieAcceptPopup(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement acceptCookies() {

		return driver.findElement(acceptCookies);
	}
}
