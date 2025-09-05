package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestTasks {
    private WebDriver driver;

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void firstTask() {
        driver.navigate().to("https://duckduckgo.com/");
        String PageTitle = driver.getTitle();
        Assert.assertEquals(PageTitle, "Google");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Assert that the DuckDuckGo logo is displayed
     * Close Google Chrome
     */

    @Test
    public void secondTask() {
        driver.navigate().to("https://duckduckgo.com/");
        By logoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
        boolean isLogoDisplayed = driver.findElement(logoLocator).isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Logo is NOT displayed");
    }


    /*** Open Google Chrome
     *    Navigate to [<a href="https://duckduckgo.com/">...</a>]
     *    Search for [Selenium WebDriver]
     *    Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">...</a>]
     *    Close Google Chrome
     *    */

    @Test
    public void thirdTask() {
        driver.navigate().to("https://www.selenium.dev/documentation/webdriver");
        String PageURL = driver.getCurrentUrl();
        Assert.assertEquals(PageURL, "https://www.selenium.dev/documentation/webdriver/");
    }


    /**
     * Open Mozilla Firefox
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */

    @Test
    public void fourthTask() {
        driver.navigate().to("https://duckduckgo.com/");
        WebElement SearchBox;
        SearchBox = driver.findElement(By.id("searchbox_input"));
        SearchBox.sendKeys("TestNG", Keys.ENTER);
        By fourthResultLocator = By.xpath("(//a[@data-testid='result-title-a'])[4]");
        String fourthResultText = driver.findElement(fourthResultLocator).getText();
        Assert.assertEquals(fourthResultText, "TestNG Tutorial");
    }


    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">...</a>]
     * Search for [Cucumber IO]
     * Assert that the link of the second result contains [<a href="https://www.linkedin.com">...</a>]
     * Close Google Chrome
     */

    @Test
    public void fifthTask() {
        driver.navigate().to("https://duckduckgo.com/");
        WebElement SearchBox = driver.findElement(By.id("searchbox_input"));
        SearchBox.sendKeys("Cucumber IO", Keys.ENTER);
        By secondResultLocator = By.xpath("(//a[@data-testid='result-title-a'])[2]");
        String secondResultLink = driver.findElement(secondResultLocator).getDomAttribute("href");
        Assert.assertTrue(secondResultLink!=null && secondResultLink.contains("linkedin.com"), "Link does NOT contain linkedin.com");
    }

    @BeforeMethod

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        driver = new ChromeDriver(options);// Code to set up test environment

    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Code to clean up after tests
    }


}
