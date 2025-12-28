package com.org.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
	
	public static String readFile(String key)
	{
		String value="";
		try {
		File f=new File("C:\\Users\\HP\\eclipse-workspace\\frame\\src\\test\\resources\\login.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties pr=new Properties();
		pr.load(fis);
		value=(String) pr.get(key);
		
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return value;
		
	}

}
