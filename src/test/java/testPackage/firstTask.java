package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class firstTask {
    public static WebDriver driver = new ChromeDriver();

    @Test
    public static void Navigate () {

        driver.navigate().to("https://duckduckgo.com/");
        String PageTitle = driver.getTitle();
        Assert.assertEquals ( PageTitle, "google.com");
    }

    @AfterTest
    public void CloseBrowser() {

        driver.quit();

    }

}
