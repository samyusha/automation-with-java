package setup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
    protected static WebDriver driver;

    public static WebDriver setupEager() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions"); // Reduce lingering processes
        driver = new ChromeDriver(options); // Assign to static driver field
        System.out.println("Created WebDriver instance: " + driver);
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Driver quit successfully: " + driver);
            } catch (Exception e) {
                System.err.println("Error closing driver: " + e.getMessage());
            } finally {
                driver = null; // Prevent reuse of stale driver
            }
        } else {
            System.out.println("Driver was null, nothing to quit");
        }
    }
}