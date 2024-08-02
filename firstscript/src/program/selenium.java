package program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

public class selenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\students\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.linkedin.com/login");

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            username.sendKeys("bineeta233@gmail.com");
            password.sendKeys("PataNahi117**");
            loginButton.click();

            Thread.sleep(5000); // Adjust as needed

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("feed")) {
                System.out.println("Test case passed");
            } else {
                System.out.println("Test case failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit(); // Ensure the driver quits
            }
        }
    }
}
