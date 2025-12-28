package com.org.PageClass;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.BasePage.BasePage;

public class LoginPage extends BasePage {
	//protected static WebDriver driver;
	protected WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		
		super(driver);
		//FirstClassPage.driver=driver;
		this.driver=driver;
		
	}
	
	private By userIds=By.xpath("//input[@type='text']");
	private By password=By.xpath("//input[@type='password']");
	private By submit=By.xpath("//button[@id='submit']");
	private By loggedOut=By.xpath("//section[@id=\"login\"]");
	
	public LoginPage enterUserId(String userId)
	{
		EnterText(userIds, userId);
		return this;
	}
	public LoginPage enterPassword(String pwd)
	{
		EnterText(password,pwd);
		return new LoginPage(driver);
	}
	public DashboardPage clickSubmit()
	{
		scrollBar("//button[@id='submit']");
		waitForElementClickable(submit);
		click(submit);
		//clickJS("//button[@id='submit']");
		return new DashboardPage(driver);
	}
	@Override
	public void navigateTo(String url) {
		driver.get(url);
		
	}
	
	@Override
	public void waitForElementClickable(By locator)
	{
		wait =new WebDriverWait(driver, Duration.ofSeconds(12000));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public LoginPage validateTestLogin() {
		boolean test= driver.findElement(loggedOut).isDisplayed();
		assertTrue(test,"Test login not displayed");
		
		return new LoginPage(driver);
	}

}
