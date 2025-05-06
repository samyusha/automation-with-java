package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class SignUp {
	
	By name = By.id("name");
	By email = By.id("email");
	By Password = By.id("password");
	By country = By.id("country");
	By number = By.id("mobile_number");
	By signUpButton =By.id("register_in");
	
	WebDriver driver;
	//WebDriverWait wait;
	
	public SignUp(WebDriver driver) {
		this.driver = driver;

	}
	
	
	
	public void name(String sname) {
		driver.findElement(name).sendKeys(sname);	
	}
	
	public void email(String semail) {
		driver.findElement(email).sendKeys(semail);	
	}
	
	public void password(String spassword) {
		driver.findElement(Password).sendKeys(spassword);	
	}
	
	
	
	public void country(String scountry) {
		WebElement dropdownElement = driver.findElement(country);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(scountry); // Use the parameter dynamically
	}
	
	public void phoneNum(String snumber) {
		driver.findElement(number).sendKeys(snumber);	
	}
	
	public void clickSignUp() {
		driver.findElement(signUpButton).click();
	}




}
