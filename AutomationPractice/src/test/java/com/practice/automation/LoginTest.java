package com.practice.automation;

//import org.testng.annotations.Test;

import com.automation.utils.Common;
import org.junit.Test;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeTest;

public class LoginTest extends Common{

  //@BeforeTest
  //public void BeforeTest()
  //{
	//  PrintResult("Automation Practice","info");
  //}
  
  @Test
  public void Login() {
	  Login.Load();
  }
  
  public void tearDown() throws Exception {
  	driver.close();
  	
      driver.quit();
  }
}
