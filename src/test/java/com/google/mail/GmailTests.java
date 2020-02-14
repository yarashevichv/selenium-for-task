package com.google.mail;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.mail.base.BaseTest;
import com.google.mail.pages.AccountsPage;
import com.google.mail.pages.EmailPage;
import com.google.mail.pages.HomePage;
import com.google.mail.pages.PasswordPage;

public class GmailTests extends BaseTest {

	@Parameters({ "email", "password", "expectedResult" })
	@Test
	public void logInSystemTest(String email, String password, String expectedSuccessResult) {

		EmailPage emailPage = new EmailPage(driver);
		emailPage.openPage();

		PasswordPage passwordPage = emailPage.enterEmailForLogIn(email);

		HomePage homePage = passwordPage.enterPasswordForLogIn(password);

		String actualResult = homePage.getTextOfIncomingLettersButton();
		Assert.assertTrue(actualResult.contains(expectedSuccessResult),
				"Actual result doesn't contain expected success result.\nActual result: " + actualResult
						+ "\nExpected result: " + expectedSuccessResult);
	}

	@Test(groups = { "Test scenario 2" })
	public void logOutSystemTest() {

		AccountsPage accountsPage = homePage.logOut();

		emailPage = accountsPage.deleteAccount();

		Assert.assertTrue(emailPage.isEmailNextButtonVisible());
	}

	@Parameters({ "email", "subject", "text", "successResult" })
	@Test(groups = { "Test scenario 3" })
	public void sendLetterTest(String email, String subject, String text, String successResult) {

		homePage.sendLetter(email, subject, text);

		String actualResult = homePage.getCountOfUnreadableLetters();
		Assert.assertTrue(actualResult.contains(successResult),
				"Actual result doesn't contain expected success result.\nActual result: " + actualResult
						+ "\nExpected result: " + successResult);
	}
}
