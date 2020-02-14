package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePageObject {
	
	private By deleteButtonLocator = By.cssSelector("li:nth-of-type(3) > div[role='link'] .stUf5b > path");
	private By selectionAccountLocator = By.cssSelector(".JDAKTe.SmR8.W7Aapd.ibdqA.zpCp3 > div[role='link']  .stUf5b > path");
	private By confirmTheDeletionLocator = By.cssSelector(".J9fJmf.XfpsVe > div:nth-of-type(1)  .RveJvd.snByac");
	
	public AccountsPage(WebDriver driver) {
		super(driver);
	}

	public EmailPage deleteAccount() {
		click(deleteButtonLocator);
		click(selectionAccountLocator);
		click(confirmTheDeletionLocator);
		return new EmailPage(driver);
	}
}
