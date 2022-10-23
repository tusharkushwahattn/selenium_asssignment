package com.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Q3- Create TestNg base project for amazon 
//(Atleast create test cases for homepage, search page, addToCart)

public class Q3 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public void Initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.in/gp/bestsellers/?ref_=nav_cs_bestsellers");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    // Navigate to Amazon Homepage
    public void Homepage() {
        driver.navigate().to("https://www.amazon.in/");
        String ExpectedHomepageURL = "https://www.amazon.in/";
        String HompageURL = driver.getCurrentUrl();
        Assert.assertEquals(HompageURL, ExpectedHomepageURL);

    }

    @Test(priority = 2)
    // Search for Iphone 14 in Search Tab
    public void SearchPage() {
        WebElement SearchTextBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        SearchTextBox.sendKeys("Iphone 14" + Keys.ENTER);
        List<WebElement> SearchResult = driver
                .findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("Search Result");
        System.out.println("******************************");
        for (int i = 0; i < SearchResult.size(); i++) {
            System.out.println(SearchResult.get(i).getText());
        }
    }

    @Test(priority = 3)
    // Verify AddToCart Functionality
    public void AddToCart() {
        wait = new WebDriverWait(driver, 10);
        String ParentWindow = driver.getWindowHandle();
        System.out.println(driver.getTitle());

        List<WebElement> SearchResult = driver
                .findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        SearchResult.get(2).click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(ParentWindow)) {
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }
        }

        WebElement AddtoCartBtn = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        AddtoCartBtn.click();

        WebElement Added = driver
                .findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        wait.until(ExpectedConditions.visibilityOf(Added));
        Assert.assertTrue(Added.isDisplayed());
        driver.switchTo().window(ParentWindow);
        System.out.println(SearchResult.get(2).getText() + " Sucessfully Added to Cart");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
