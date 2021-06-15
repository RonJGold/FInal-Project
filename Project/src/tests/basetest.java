package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class basetest  {
	WebDriver driver;
	SoftAssert sa ;
	
	public basetest() {
		driver = new ChromeDriver();
		 sa = new SoftAssert();
	}
}
