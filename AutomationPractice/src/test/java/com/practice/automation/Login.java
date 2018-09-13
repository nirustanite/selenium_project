package com.practice.automation;

import java.io.FileNotFoundException;

import com.automation.utils.Common;

public class Login extends Common{

	public static void Load()
	{
		try {
			Load_driver(read("Browser_Type"));
			driver.get(Common.read("Site_URL"));
			if(Common.explicit_Wait("//*[@class='logo img-responsive']"))
			{
				Common.PrintResult("Site is loading fine", "info");
			}
			else
			{
				Common.PrintResult("Site is down", "error");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
