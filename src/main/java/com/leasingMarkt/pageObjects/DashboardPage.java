package com.leasingMarkt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	public WebDriver driver;

	private By searchField = By.id("search_field");

	public DashboardPage(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getSearchField() {
		return driver.findElement(searchField);
	}

}
