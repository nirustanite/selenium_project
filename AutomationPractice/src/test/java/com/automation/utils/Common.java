package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public static String value = "";
	public static WebDriver driver;
	public static Logger logger;
	public static WebDriverWait webdriverwait;
	public static boolean flag;

	public static String read(String key) throws FileNotFoundException
	{
		try {
			File file = new File("test.properties");
			FileInputStream fileinput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileinput);
			value= properties.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			PrintResult("While reading properties file, Exception is occured. Error is " + e.getMessage(),"error");
		}
	    return value;
		
	}
	
	public static void Load_driver(String browser_name)
	{
		try
		{
			if(browser_name.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe"); 
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
			}
			else
			{
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			PrintResult(browser_name+" driver is loaded properly.","info");
		}
		catch(Exception e)
		{
			PrintResult(browser_name+" driver is not loaded properly.","error");
		}
	}
	
	public static void info(String message)
	{
		logger = Logger.getLogger("");
		logger.info(message);
	}
	public static void error(String message)
	{
		logger = Logger.getLogger("");
		logger.error(message);
	}
	public static void warn(String message)
	{
		logger = Logger.getLogger("");
		logger.warn(message);
	}
	
	public static void PrintResult(String result,String passfail)
	{
	   if(passfail.equalsIgnoreCase("info"))
	   {
		   info(result);
	   }
	   else if(passfail.equalsIgnoreCase("error"))
	   {
		   error(result);
	   }
	   else
	   {
		   warn(result);
	   }
	}
	
	public static boolean explicit_Wait(String xpath)
	{
		flag = false;
		try
		{
			webdriverwait = new WebDriverWait(driver, 120);
			webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			flag = true;
		}
		catch(Exception e){}
		return flag;
	}
	
	public static void Driver_Quit()
	{
		try
		{
			driver.quit();
		}
		catch(Exception t)
		{
			PrintResult("Error occured while closing browser. Error is "+t.getMessage(),"error");
		}
	}
}
