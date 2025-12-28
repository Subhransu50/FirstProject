package com.org.testClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.BaseTest.BaseTest;
import com.org.PageClass.LoginPage;
import com.org.util.ReadPropertyFile;

import jdk.internal.org.jline.utils.Log;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider = "logincredentials")
	public void LoginApp(String userid,String password)
	{
		LoginPage obj=new LoginPage(driver);
		obj.navigateTo(ReadPropertyFile.readFile("url"));
		obj.enterUserId(userid)
		.enterPassword(password)
		.clickSubmit()
		.validateLoggedInSuccessfully("Logged In Successfully");
	}
	
	@DataProvider(name="logincredentials")
	public Object[][] getData()
	{
		return new Object[][]{ {"student","Password123"}
		//,{"abc","random"}
		};
		
	}
	
	@Test(priority = 1)
	public void LoginWithHardCodedValue()
	{
		LoginPage obj=new LoginPage(driver);
		obj.navigateTo("https://practicetestautomation.com/practice-test-login/");
		obj.enterUserId("student")
		.enterPassword("Password123")
		.clickSubmit()
		.validateLoggedInSuccessfully("Logged In Successfully");
		Log.warn("");
		
	}
	
	@Test(priority = -1)
	public void loginTest() {
	    Logger log = LogManager.getLogger(BaseTest.class);;
		log.info("Browser launched");
	    log.info("Navigating to URL");
	    log.info("Entering username");
	    log.info("Entering password");
	    log.info("Login successful");
	}
	@Test(dependsOnMethods = "LogB")
	public void LogA(String userid,String password)
	{
		LoginPage obj=new LoginPage(driver);
		obj.navigateTo(ReadPropertyFile.readFile("url"));
		obj.enterUserId(userid)
		.enterPassword(password)
		.clickSubmit()
		.validateLoggedInSuccessfully("Logged In Successfully");
	}
	
	
	
	@Test 
	public void LogB()
	{
		LoginPage obj=new LoginPage(driver);
		obj.navigateTo("https://practicetestautomation.com/practice-test-login/");
		obj.enterUserId("student")
		.enterPassword("Password123")
		.clickSubmit()
		.validateLoggedInSuccessfully("Logged In Successfully");
		Log.warn("");
		
	}


}
