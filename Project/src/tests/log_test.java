package tests;

import org.testng.annotations.Test;

import pages.log_in;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class log_test extends basetest {
	// Local variables 

	log_in log ;
	sdk.logger logger ;
	@Test(dataProvider = "password_only")
	public void password_only( String pass ) {
		  
		  try {
			  logger.event("pass_only", "Log in by using  by only entering the password" );
			  logger.info("pass_only", "Enter The password here: " + pass);
			  log.enter_password(pass);
			  logger.info("pass_only", "CLick on the log in button");
			  log.log_btn();
			  String result = log.wrong_info()  ;
logger.info("pass_only", result);

		  }
		  catch (Exception e) {
			  String actutal = e.getMessage() ;
			  sa.assertEquals(actutal, "Expected condition failed: waiting for visibility of element located by By.xpath: /html/body/div[2]/ul/li (tried for 10 second(s) with 500 milliseconds interval)\n"
			  		+ "");
			  logger.exception("password_only", " The Expected Error   Massage  Is Showing  : " + "\n" +   actutal );
			  
		  }
	  }	
@Test(dataProvider = "correct_information")
  public void correct_information(String name, String pass , String exp_result) {
	  
	  try {
		  logger.event("correct_information", "Loggin with the correct information" );
		  logger.info("correct_information", "Enter your correct username here: " +  name);
		  log.enter_username(name);
		  logger.info("correct_information", "Enter your correct password here: " +  pass);
		  log.enter_password(pass);
		  logger.info("correct_information", "CLick on the log in button");
		  log.log_btn();
		  String result = log.correct_info() ;
		  sa.assertEquals(result, exp_result);
		  logger.info("correct_information", "The acutal result " + result + " , " + "The expected result " + exp_result );
		  log.sign_out();

	  }
	  catch (Exception e) {
		  String errmsg ;
		  errmsg = e.getMessage() ;
		  System.out.println(errmsg);
		  logger.exception("correct_information", errmsg);
		  
	  }
  }
  
  @Test(dataProvider = "wrong_data")
  public void wrong_data(String name, String pass ) {
	 
	  try {
		  logger.event("wrong_data", "Log in by using  false information" );
		  logger.info("wrong_data", "Enter an incorrect username  or password here: " +  name + " , " + pass);
		  log.enter_username(name);
		  log.enter_password(pass);
		  logger.info("wrong_data", "CLick on the log in button");
		  log.log_btn();
		  String result = log.wrong_info()  ;

		  sa.assertEquals(result, "Invalid username or password. Signon failed.");
		  logger.info("wrong_data", "The acutal result: " + result + " , " + "The expected result: " + "Invalid username or password. Signon failed." );

	  }
	  catch (Exception e) {
		  String errmsg ;
		  errmsg = e.getMessage() ;
		  logger.exception("wrong_data", errmsg);
		  
	  }
	  
  }
 
  

  
 
  @BeforeMethod
  public void beforeMethod() {
	  log.open();
	  



  }

  @AfterMethod
  public void afterMethod() {
	  
	 
  }


  @DataProvider(name = "correct_information") 
  public Object[][] correct_information() {
	  Object[][] data = new Object[][] {
		  {"ronjgold","GR4892isr","Welcome Ron!"} 

		  
	  };
	  return data;
  
  
}
  @DataProvider(name = "wrong_data") 
  public Object[][] wor() {
	  Object[][] data = new Object[][] {
		  {"ronjgold","rg4892isr"}, 
		  {"RONJGOLD","RG4892isr"}
	  };
	  return data;
  
  
}
  
  @DataProvider(name = "password_only") 
  public Object[][] password_only() {
	  Object[][] data = new Object[][] {
		  {"RG4892isr"}
	  };
	  return data;
  
  
}
  
 
  
  
 
  


  
  @BeforeClass
  public void beforeClass() {
	  log = new log_in(driver) ;
	  logger = new sdk.logger();

  }

  @AfterClass
  public void afterClass() {
	  log.close();
	  logger.event("log_test", "Close Browser" );
	  logger.print();

	  
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
