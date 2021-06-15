package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class log_in extends basepage {
	
	final static String myUrl="https://petstore.octoperf.com/actions/Account.action?signonForm=";

	

public log_in(WebDriver d) {
		super(d, myUrl);
		// TODO Auto-generated constructor stub
	}
// Returning  the Welcome  statement  From The Main Page 
public String correct_info( ) {
	WebElement act = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div")));
	return act.getText();
	
}
//Returning "Invalid username or password. Signor failed"

public String wrong_info( ) {
	WebElement act = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/ul/li")));
	return act.getText();
	
}

//Entering the username 
public void enter_username(String username) {
	WebElement act = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	act.sendKeys(username);
	

}

// clearing the password field and Entering a new one
public void enter_password(String password) {
	
	WebElement act = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	act.clear();
	act.sendKeys(password);
	

}
// Clicking on the log in button 
public void log_btn() {
	WebElement act = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.name("signon")));
	act.click();
}

public void sign_out()
{
	WebElement act = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MenuContent\"]/a[2]")));
	act.click();
}


}
