package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

	private By incomingLettersLocator = By.xpath(
			"/html/body[@class='aAU']/div[7]/div[@class='nH']/div[@class='nH']/div[2]/div[@class='no']/div[1]/div[@class='Ls77Lb aZ6']/div[@class='aj9 pp']/div[@class='oo']//div[@role='navigation']/div/div[@class='n3']//div[@class='aim ain']/div//a[@title='Входящие']");
	private By iconOfAccountLocator = By
			.xpath("/html//header[@id='gb']/div[2]/div[3]/div[@class='gb_Uc']/div[2]/div/a[@role='button']");
	private By exitButtonLocator = By.linkText("Выйти");
	private By writeLetterButtonLocator = By.cssSelector(".aic  div[role='button']");
	private By addresseeLocator = By.xpath(
			"/html/body[@class='aAU']/div[@class='dw']/div/div[@class='nH']/div[@class='nH']/div[@class='no']//div[@role='dialog']//div[@class='M9']/div[@role='region']/table//td[@class='I5 bzE']/form/div[1]/table[@class='GS']/tbody/tr[1]/td[@class='eV']/div[@class='oj']//textarea[@role='combobox']");
	private By subjectLocator = By.xpath(
			"/html/body[@class='aAU']/div[@class='dw']/div/div[@class='nH']/div[@class='nH']/div[@class='no']//div[@role='dialog']//div[@class='M9']/div[@role='region']/table//td[@class='I5 bzE']/form/div[@class='aoD az6']//input[@name='subjectbox']");
	private By textOfLetterLocator = By.cssSelector("#\\:9z");
	private By sendButtonLocator = By.cssSelector(".dC > div:nth-of-type(1)");
	private By countOfUnreadableLettersLocator = By.xpath(
			"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div[1]/div/div/div[2]/div");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getTextOfIncomingLettersButton() {
		return getText(incomingLettersLocator);
	}

	public AccountsPage logOut() {
		click(iconOfAccountLocator);
		click(exitButtonLocator);

		return new AccountsPage(driver);
	}

	public void sendLetter(String email, String subject, String text) {
		click(writeLetterButtonLocator);

		type(email, addresseeLocator);
		type(subject, subjectLocator);
		click(textOfLetterLocator); type(text, textOfLetterLocator);
		 

		click(sendButtonLocator);
	}

	public String getCountOfUnreadableLetters() {
		return getText(countOfUnreadableLettersLocator);
	}
}
