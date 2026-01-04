package com.org.BaseTest;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	
	//protected static WebDriver driver;
	protected  WebDriver driver;
	//protected static Logger log;
	@Parameters("crossbrowser")
	@BeforeMethod
	public void initialize(String browser) throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		//ChromeOptions op = new ChromeOptions();
		//op.addArguments("--headless");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		String downloadPath = System.getProperty("user.dir") + "/downloads";

		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);

		// 🔥 VERY IMPORTANT (your missing part)
		prefs.put("safebrowsing.enabled", false);
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
		
		

		

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		//options.addArguments("--headless"); // Run in headless mode
		options.addArguments("--no-sandbox"); // Required in many cloud environments
		options.addArguments("--disable-dev-shm-usage"); // Avoid /dev/shm issues
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--remote-allow-origins=*"); // Fix CORS issues in Chrome 111+
		

			//driver=new ChromeDriver(options);
			
			
			//grid setup
			
			  cap.setBrowserName("chrome"); 
			  driver=new RemoteWebDriver(new URL("http://3.239.181.24:4444"),cap);
			 
			
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			//driver=new EdgeDriver();
			
			//grid setup
			
			  cap.setBrowserName("MicrosoftEdge"); 
			  driver=new RemoteWebDriver(new URL("http://3.239.181.24:4444"),cap);
			 
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
	}
	
	
	
	@AfterMethod
	public void cleanUp()
	{
		if(driver!=null)
		{
			takeScreenshotOfWebPage(driver);
			//driver.close();
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
