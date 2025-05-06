package testpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import pages.Login;
import pages.SignUp;
import setup.DriverSetup;

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

	@Test
	public void signupTest() {
	    signupo = new SignUp(driver);
		signupo.name("sara venkat");
		signupo.email("sara@yopmail.com");
		signupo.password("S123456");
		signupo.country("AF");
		signupo.phoneNum("8978678987");
		signupo.clickSignUp();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Option 1: Check for URL redirect (adjust URL as needed)
        String expectedUrlPart = "https://apps.skillup.online/learner-dashboard/"; // Replace with actual URL part (e.g., "dashboard", "login")
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlPart), 
            "Signup failed: URL does not contain '" + expectedUrlPart + "'");
	}
	
	@AfterMethod
	public void close() {
		DriverSetup.tearDown();
	}

}
