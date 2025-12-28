package com.org.testClass;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.BaseTest.BaseTest;
import com.org.PageClass.LoginPage;

public class ScenarioTest extends BaseTest{
	
	@Test
	public void Login() {
		LoginPage obj = new LoginPage(driver);
		obj.navigateTo("https://practicetestautomation.com/practice-test-login/");
		obj.enterUserId("student")
		.enterPassword("Password123")
		.clickSubmit()
		.validateUrlContains("practicetestautomation.com/logged-in-successfully/")
		.validateLogOut()
		.validateLoggedInSuccessfully("Logged In Successfully")
		.logOut()
		.validateTestLogin();
		
	}
	
	@Test
	public void Ok()
	{
		assertTrue(false);
	}
	
	@Test(retryAnalyzer = com.org.utils.RetryAnalyzer.class)
	public void failedTestExample() {
	    Assert.fail();
	    
	}


}
