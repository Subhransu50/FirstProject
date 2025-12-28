package com.org.testClass;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.org.BaseTest.BaseTest;
import com.org.PageClass.LoginPage;
import com.org.util.ReadPropertyFile;

import jdk.internal.org.jline.utils.Log;

public class DependsOn extends BaseTest{
	
	@Test(dependsOnMethods = "LogB")
	public void LogA()
	{
		LoginPage obj=new LoginPage(driver);
		obj.navigateTo(ReadPropertyFile.readFile("url"));
		obj.enterUserId("student")
		.enterPassword("Password123")
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
		//Log.warn("");
		
		assertTrue(false);
		
	}
	
	
	@Test(dependsOnMethods = "LogB", alwaysRun = true)
	public void LogC()               
	{
		LoginPage obj=new LoginPage(driver);
		obj.navigateTo(ReadPropertyFile.readFile("url"));
		obj.enterUserId("student")
		.enterPassword("Password123")
		.clickSubmit()
		.validateLoggedInSuccessfully("Logged In Successfully");
	}

}
