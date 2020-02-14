package com.google.mail.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.mail.pages.AccountsPage;
import com.google.mail.pages.EmailPage;
import com.google.mail.pages.HomePage;
import com.google.mail.pages.PasswordPage;

public class BaseTest {

	protected WebDriver driver;
	protected EmailPage emailPage;
	protected PasswordPage passwordPage;
	protected HomePage homePage;
	protected AccountsPage accountsPage;

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setUp(@Optional String browser) {

		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();

		driver.manage().window().maximize();
	}

	@Parameters({ "email", "password" })
	@BeforeGroups({ "Test scenario 2", "Test scenario 3" })
	public void logIn(String email, String password) {

		emailPage = new EmailPage(driver);
		emailPage.openPage();

		passwordPage = emailPage.enterEmailForLogIn(email);
		homePage = passwordPage.enterPasswordForLogIn(password);
	}

	@AfterGroups({ "Test scenario 3" })
	public void logOut() {

		accountsPage = homePage.logOut();
		accountsPage.deleteAccount();
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		
		driver.quit();
		
	}
}
