package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class secondTask extends firstTask {

    @Test

    public void logoIsDisplayed() throws InterruptedException {
        //WebElement logo= driver.findElement(By.cssSelector("meta[property='og:image']"));
       WebElement logo = driver.findElement(By.cssSelector("header_logoHorizontal__KABN4 header_logoText__d_X6V header_logoImg__85jCX"));
        Assert.assertTrue(logo.isDisplayed());
       // Assert.assertFalse(logo.isDisplayed());

    }


}
