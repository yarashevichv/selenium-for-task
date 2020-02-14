package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailPage extends BasePageObject {

	private String pageUrl = "https://gmail.com";

	private By emailLocator = By.id("identifierId");
	private By emailNextButtonLocator = By.id("identifierNext");

	public EmailPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		openUrl(pageUrl);
	}

	public PasswordPage enterEmailForLogIn(String email) {
		type(email, emailLocator);
		click(emailNextButtonLocator);
		return new PasswordPage(driver);
	}
	
	public Boolean isEmailNextButtonVisible() {
		return find(emailNextButtonLocator).isDisplayed();
	}
}
