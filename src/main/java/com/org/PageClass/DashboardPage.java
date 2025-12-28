package com.org.PageClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.org.BasePage.BasePage;

import jdk.internal.org.jline.utils.Log;

public class DashboardPage extends BasePage{

	protected WebDriver driver;
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	@Override
	public void navigateTo(String url) {
		// TODO Auto-generated method stub
		
	}
	
	private By loggedInSuccessfuly=By.xpath("//h1");
	private By displayLogOut=By.xpath("//a[@class=\"wp-block-button__link has-text-color has-background has-very-dark-gray-background-color\"]");
	private By logging=By.xpath("//a[@class=\"wp-block-button__link has-text-color has-background has-very-dark-gray-background-color\"]");

	
	public DashboardPage validateLoggedInSuccessfully(String expectedText)
	{
		String actualText=getText(loggedInSuccessfuly);
		Assert.assertEquals(actualText, expectedText,"assertion failed");
		
		return this;
	}
	
	public DashboardPage validateUrlContains(String expectedString) {
		String st = driver.getCurrentUrl();
		st.concat(expectedString);
		//Assert.assertEquals(st, expectedString,"");
		assertTrue(st.contains(expectedString),"");
		
		return this;
		
		
	}
	public DashboardPage validateLogOut() {
		boolean log=driver.findElement(displayLogOut).isDisplayed();
		assertTrue(log,"Logout button not found");
		
		return new DashboardPage(driver);
	}
	
	public LoginPage logOut() {
		driver.findElement(logging).click();
		return new LoginPage(driver);
	}
	
	
}
