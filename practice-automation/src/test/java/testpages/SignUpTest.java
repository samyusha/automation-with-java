package testpages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import pages.Login;
import pages.SignUp;
import setup.DriverSetup;
import utils.ExcelReader;

public class SignUpTest {

	WebDriver logindriver;
	WebDriver userdriver;
	WebDriver driver;
	SignUp signupo;
	Login logino;

	@BeforeMethod
	public void signtest() throws InterruptedException {
		driver = DriverSetup.setupEager();
		driver.get("https://courses-in.skillup.online/register");
	}
	
	@DataProvider(name = "signupData")
    public Object[][] getSignupData() throws IOException {
        List<Object[]> excelData = ExcelReader.readExcelData("SignupTestdata");
        return excelData.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "signupData")
    public void signupTest(String name, String email, String password, String country, String phone) {
        signupo = new SignUp(driver);
        signupo.name(name);
        signupo.email(email);
        signupo.password(password);
        signupo.country(country);
        signupo.phoneNum(phone);
        signupo.clickSignUp();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Option 1: Check for URL redirect (adjust URL as needed)
        String expectedUrlPart = "https://courses-in.skillup.online/verify/"; // Replace with actual URL part (e.g., "dashboard", "login")
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlPart), 
            "Login failed: URL does not contain '" + expectedUrlPart + "'");
	}
	
	@AfterMethod
	public void close() {
		DriverSetup.tearDown();
	}

}
