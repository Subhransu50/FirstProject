package com.org.testClass;

import org.testng.annotations.Test;

import com.org.BaseTest.BaseTest;
import com.org.PageClass.PracticePage;

public class PracticeTest extends BaseTest{
	
	@Test
	public void getBrokenImage() throws Exception
	{
		PracticePage p=new PracticePage(driver);
		p.navigateTo("https://practice.expandtesting.com/broken-images");
		p.brokenImage();
	}
	@Test
	public void readTable()
	{
		PracticePage p=new PracticePage(driver);
		p.navigateTo("https://practicetestautomation.com/practice-test-table/");
		p.readTable();
	}
	@Test
	public void authentication()
	{
		PracticePage p=new PracticePage(driver);
		p.authentication();
		
	}
	@Test
	public void downloadFiles() throws Exception
	{
		PracticePage p=new PracticePage(driver);
		p.navigateTo("https://practice.expandtesting.com/download");
		p.downloadFile();
	}
	@Test
	public void uploadFiles() throws InterruptedException
	{
		PracticePage pg=new PracticePage(driver);
		pg.navigateTo("https://practice.expandtesting.com/upload");
		pg.uploadfile();
		
	}
	@Test
	public void multipleHandle() throws InterruptedException
	{
		PracticePage pg=new PracticePage(driver);
		pg.navigateTo("https://practice.expandtesting.com/windows");
		pg.windowHandle();
	}
	@Test
	public void SelectDropdown() throws InterruptedException
	{
		PracticePage p=new PracticePage(driver);
		p.navigateTo("https://practice.expandtesting.com/dropdown");
		p.dropDown("Algeria");
	}
	@Test
	public void handleShadowRootElement()
	{
		PracticePage p=new PracticePage(driver);
		p.navigateTo("https://practice.expandtesting.com/shadowdom");
		p.handleShadoeElement();
	}

}
