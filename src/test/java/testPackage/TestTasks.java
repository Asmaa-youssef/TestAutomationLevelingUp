package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class TestTasks {
WebDriver driver = new ChromeDriver();

    /***
     * Open Google Chrome
     * Navigate to [https://duckduckgo.com/]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
public void FirstTest() {
    driver.navigate().to("https://duckduckgo.com/");
    String PageTitle = driver.getTitle();
    assertEquals(PageTitle,"Google");
}
/*** Open Google Chrome
 Navigate to [https://duckduckgo.com/]
 Assert that the DuckDuckGo logo is displayed
 Close Google Chrome
    */

 @Test
public void SecondTest() {
        driver.navigate().to("https://duckduckgo.com/");

}





    @BeforeMethod
    public void setUp() {
        // Code to set up test environment
    }

   // @AfterMethod
    public void tearDown() {
       driver.quit(); // Code to clean up after tests
    }

}

