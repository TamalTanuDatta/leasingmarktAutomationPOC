package com.leasingMarkt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	private By username = By.id("login-form-username");
	private By password = By.id("login-form-password");
	private By loginButton = By.xpath("//input[@type='submit']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getUserName() {

		return driver.findElement(username);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement getLoginButton() {

		return driver.findElement(loginButton);
	}

}
