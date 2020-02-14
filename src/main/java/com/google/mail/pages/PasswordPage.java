package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage extends BasePageObject {
	
	private By passwordLocator = By.cssSelector("input[name='password']");
	private By passwordNextButtonLocator = By.id("passwordNext");

	public PasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage enterPasswordForLogIn(String password) {
		type(password, passwordLocator);
		click(passwordNextButtonLocator);
		return new HomePage(driver);
	}
}
