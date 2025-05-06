package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver; //instance variable
	public Login(WebDriver driver) {
        this.driver = driver;  
    }
	
	By email = By.id("email");
	By password = By.id("password");
	By submitButton = By.id("login_in");
	
	public void enterEmail(String uemail) {
		driver.findElement(email).sendKeys(uemail);
	}
	
	public void enterPassword(String upassword) {
		driver.findElement(password).sendKeys(upassword);
	}
	
	public void clickLogin() {
		driver.findElement(submitButton).click();
	}
			
	
}
