package com.google.mail.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl(String url) {
		waitForLoadingOfPage();
		driver.get(url);
	}

	public WebElement find(By locator) {
		waitForVisibilityOf(locator, 25);
		return driver.findElement(locator);
	}

	public void click(By locator) {
		waitForVisibilityOf(locator, 25);
		find(locator).click();
	}

	public void type(String text, By locator) {
		waitForVisibilityOf(locator, 25);
		find(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		waitForVisibilityOf(locator, 25);
		return find(locator).getText();
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 20;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	private void waitForLoadingOfPage() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	private void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;

		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.elementToBeClickable(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
		}
	}
}
