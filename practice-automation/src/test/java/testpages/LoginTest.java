package testpages;
import org.openqa.selenium.WebDriver;
import pages.Login;
import setup.DriverSetup;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

//import setup.DriverSetup;

public class LoginTest {
//Instance variable declaration	
WebDriver driver;
Login logino;

@BeforeMethod
public	void call() {
	driver = DriverSetup.setupEager();
	driver.get("https://courses-in.skillup.online/login");
	
	
	}
@Test
void loginFunction() {
	logino = new Login(driver);
	logino.enterEmail("samyuktha@skillup.tech");
	logino.enterPassword("S123456");
	logino.clickLogin();
	
}

@AfterMethod
public void close() {
	DriverSetup.tearDown();
}


}
