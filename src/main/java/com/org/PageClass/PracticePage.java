package com.org.PageClass;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.BasePage.BasePage;

public class PracticePage extends BasePage{
	protected WebDriver driver;
	public PracticePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	private By img=By.xpath("//div[@class='col-md-1 mx-2']//img");
	private By rows=By.xpath("//table[@id='courses_table']//tbody//tr");
	private By fileName=By.xpath("//a[@data-testid='1767068966558_Sample2.txt']//*[local-name()='svg']");
	private By file=By.xpath("//input[@type='file']");
	private By drop=By.xpath("//select[@id='country']");
	private By window=By.xpath("//a[text()='Click Here']");
	private By shadow=By.xpath("//div[@id='shadow-host']");

	@Override
	public void navigateTo(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		
		
	}
	public void brokenImage() throws Exception
	{
		List<WebElement> li=driver.findElements(img);
		//driver.findElement(img).getAttribute("href");
		//WebElement el=driver.findElement(img);
		//el.click();
		for(int i=0;i<li.size();i++)
		{
			String attributeValue=li.get(i).getAttribute("src");
			URL url=new URL(attributeValue);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			if(conn.getResponseCode()!=200 && conn.getResponseCode()!=201)
			{
				System.out.println("Broken image is "+attributeValue);
			}
		}
		
	}
	public void readTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.id("courses_table")));
	    List<WebElement> li = driver.findElements(rows);
	    System.out.println("Rows count: " + li.size());

	    for (int i = 1; i <= li.size(); i++) {   

	        By col = By.xpath("(//table[@id='courses_table']//tbody//tr)[" + i + "]//td");

	        List<WebElement> li1 = driver.findElements(col);

	        //for (WebElement el : li1) 
	        for(int j=0;j<li1.size();j++)
	        {
	            //System.out.println(el.getText() + " | ");
	        	System.out.println(li1.get(j).getText());
	        }
	        System.out.println();
	    }
	}
	
	public void authentication()
	{
		
		driver.get("https://admin:admin@practice.expandtesting.com/basic-auth");
		System.out.println(driver.getTitle());

	}
	public void downloadFile() throws Exception
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(fileName));
		driver.findElement(fileName).click();
		Thread.sleep(5000);
		
	}
	
	public PracticePage uploadfile() throws InterruptedException {
		
		scrollIntoView(driver.findElement(file));
		driver.findElement(file).sendKeys("C:\\Users\\HP\\Desktop\\ok.txt");
		Thread.sleep(4000);
		return this;
	}
	
	public void dropDown(String str ) throws InterruptedException {
		Select sc=new Select(driver.findElement(drop));
		sc.selectByVisibleText(str);
		Thread.sleep(4000);
	}
	
	public void windowHandle() throws InterruptedException {
		String firstWindow = driver.getWindowHandle();
		driver.findElement(window).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String win : allWindows) {
	        if (!win.equals(firstWindow)) {
	            driver.switchTo().window(win);
	            break;
	        }
	    }
		driver.switchTo().window(firstWindow);
		Thread.sleep(5000);
		
	}
public void handleShadoeElement()
{
	scrollIntoView(driver.findElement(shadow));
	SearchContext sc=driver.findElement(shadow).getShadowRoot();
	
	sc.findElement(By.cssSelector("#my-btn")).click();
}

}
