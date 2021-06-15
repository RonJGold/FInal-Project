package tests;

import org.testng.annotations.Test;

import pages.main_animal;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class lnk_test extends basetest {
// Local variables 
	main_animal lnk ;
	sdk.logger logger ;
	
	
		

	
@Test(dataProvider = "animal_links")
 public void animal_link(int lnk_type, String animal , String exp_result  ) {
		
		  try {
			  logger.info("animal_link", "The specific type of link  is : " + lnk.catogry_lnk(lnk_type));
			  String result = lnk.get_result(lnk_type, animal) ;
			 sa.assertEquals(result, exp_result);

			  logger.info("animal_link", "The Actual Animal page we have reached  : " + result + " , " + "The desired Animal Page  is : " + exp_result);
			  lnk.return_main();
			
			  
		  }
		  catch (Exception e) {
			  String errmsg ;
			  errmsg = e.getMessage() ;
			  logger.exception("missing_data", errmsg);
			  
		  }


  }
  @BeforeMethod
  public void beforeMethod() {
	  lnk.open();
	  logger.event("animal_link", " Let's Check if the specific link is  working: " );
  }

  @AfterMethod
  public void afterMethod() {
  }

  /* Types of links 
	 * 1. Main Links
	 * 2 . Sidebar Links
	 * 3 . Quick Links
	 */
  
	  @DataProvider(name = "animal_links") 
	  public Object[][] enter_links() {
		  Object[][] data = new Object[][] {
			  {1,"Fish" ,"Fish"} ,
			  {1,"Dogs" ,"Dogs"} ,
			  {1,"Cats","Cats"} ,
			  {1,"Reptiles" ,"Reptiles"} ,
			  {1,"Birds" ,"Birds"},
			  {2,"Fish","Fish"} ,
			  {2,"Dogs" ,"Dogs"} ,
			  {2,"Cats","Cats"} ,
			  {2,"Reptiles","Reptiles"} ,
			  {2,"Birds","Birds"}, 
			  {3,"Fish","Fish"} ,
			  {3,"Dogs","Dogs"} ,
			  {3,"Cats" ,"Cats"} ,
			  {3,"Reptiles","Reptiles"} ,
			  {3,"Birds" ,"Birds"}, 
			  {4 , "Birds" , "Birds"} , {3 , "Horses" , "Horses" }

		  };
		  return data;
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  lnk = new main_animal(driver);
	  logger = new sdk.logger();

	  
  }

  @AfterClass
  public void afterClass() {
	  lnk.close();
	  logger.event("animal_link", "Close Browser" );
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
