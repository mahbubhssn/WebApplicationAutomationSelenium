package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage {
    @Test
    public void homePage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("http://x4t.seliselocal.com/");
        driver.get("https://www.google.com/");
        driver.manage().window().fullscreen();

        WebElement marketElement = driver.findElement(By.xpath("//span[text()='Market']") );
        marketElement.click();

        Thread.sleep(5000);
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search by Crypto Currency Name']"));
        WebDriverWait await = new WebDriverWait(driver, Duration.ofSeconds(8));
        await.until(ExpectedConditions.visibilityOf(searchField));

        searchField.sendKeys("Bitcoin");
        Thread.sleep(5000);
        searchField.sendKeys(Keys.ENTER);

    }
}
