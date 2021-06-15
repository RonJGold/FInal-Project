package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basepage {
	WebDriver driver;
	WebDriverWait wait;
	String url;
	
	basepage(WebDriver d , String url){
		driver = d ;
		this.url = url ;
		wait = new WebDriverWait(driver,10); 

	}
	
	public void open() {
		driver.get(url);
	}
	public void close() {
		driver.quit();
	}
}
