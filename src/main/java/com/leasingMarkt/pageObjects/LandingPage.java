package com.leasingMarkt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	private By konto = By.xpath("//div[contains(@class,'dropdown-control') and contains(@class, 'cursor-pointer')]");
	private By loginLink = By.xpath("//a[@href='https://de-7.leasingmarkt.dev/login']");

	public LandingPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getKonto() {

		return driver.findElement(konto);
	}

	public WebElement getloginLink() {
		return driver.findElement(loginLink);
	}

}
