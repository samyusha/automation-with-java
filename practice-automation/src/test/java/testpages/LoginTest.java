package testpages;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import pages.Login;
import setup.DriverSetup;
import utils.ExcelReader;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
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
	
@DataProvider(name = "loginData")
public Object[][] getLoginData() throws IOException {
    List<Object[]> excelData = ExcelReader.readExcelData("TestDataLOGIN");
    return excelData.toArray(new Object[0][0]);
}

@Test(dataProvider = "loginData")
public void loginFunction(String email, String password) {
    logino = new Login(driver);
    logino.enterEmail(email);
    logino.enterPassword(password);
    logino.clickLogin();
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    String expected_url = "https://apps.skillup.online/learner-dashboard/"; 
    wait.until(ExpectedConditions.urlContains(expected_url));
    Assert.assertTrue(driver.getCurrentUrl().contains(expected_url), 
            "Login failed: URL does not contain '" + expected_url + "'");
    }

@AfterMethod
public void close() {
	DriverSetup.tearDown();
}


}
