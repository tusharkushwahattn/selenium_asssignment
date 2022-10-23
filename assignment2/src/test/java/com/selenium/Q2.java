package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Q2- https://rahulshettyacademy.com/dropdownsPractise/
//Try to handle radio button
//Try to handle dynamic dropdown

public class Q2 {
    static WebDriver driver;

    @BeforeClass
    public void Initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void RadioButtons() {
        List<WebElement> RadioBtn = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']"));
        System.out.println("Size of Radio buttons is " + RadioBtn.size());
        RadioBtn.get(0).click();
        Assert.assertTrue(RadioBtn.get(0).isSelected());
    }

    @Test
    public void DropDown() {
        WebElement Searchbtn = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
        Searchbtn.click();
        List<WebElement> from = driver.findElements(By.xpath("(//div[@id='dropdownGroup1'])[1]//li"));
        from.get(36).click();
        List<WebElement> to = driver.findElements(By.xpath("(//div[@id='dropdownGroup1'])[2]//li"));
        to.get(10).click();

    }

    @AfterClass
    public void close() {
        driver.close();
    }

}
