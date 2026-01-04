package com.org.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public abstract class BasePage {

	//protected static WebDriver driver;
	protected WebDriver driver;
	protected WebDriverWait wait;
	JavascriptExecutor js;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		wait =new WebDriverWait(driver, Duration.ofSeconds(5000));
		js=(JavascriptExecutor)driver;
		
	}
	public abstract void navigateTo(String url);
	
	
	public void EnterText(By locator,String text)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		waitForElementClickable(locator);
		driver.findElement(locator).sendKeys(text);
	}
	public void click(By locator)
	{
		driver.findElement(locator).click();
	}
	public void waitForElementClickable(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public String getText(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String text=driver.findElement(locator).getText();
		return text;
	}
	public void scrollBar(String locator)
	{
		
		js.executeScript(locator, "arguments[0].scrollIntoView();");
	}
	public void clickJS(String locator)
	{
		js.executeScript(locator, "arguments[0].click();");
	}
	
	public void scrollIntoView(WebElement ele){
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
}
