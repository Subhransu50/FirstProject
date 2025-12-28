package com.org.BaseTest;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	
	//protected static WebDriver driver;
	protected  WebDriver driver;
	//protected static Logger log;
	//@Parameters("crossbrowser")
	@BeforeMethod
	public void initialize()
	{
		//ChromeOptions op = new ChromeOptions();
		//op.addArguments("--headless");
		
		//if(browser.equalsIgnoreCase("chrome"))
		
			driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
	}
	
	
	
	@AfterMethod
	public void cleanUp()
	{
		if(driver!=null)
		{
			takeScreenshotOfWebPage(driver);
			driver.close();
			driver.quit();
		}
	}
	public void takeScreenshotOfWebPage(WebDriver driver)
	{
		try
		{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/frame/src/main/resources/Screenshot"+"abc.png"));
		}catch(Exception e)
		{
			
		}
	}
	
	

}
