package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {
    public WebDriver driver;
    public Actions action;

    @BeforeMethod
    public void Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action = new Actions(driver);
    }

    @Test
    public void Automate_travel() {
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("New Delhi");
        driver.findElement(By.xpath("(//input[@type='text'])[2]"))
                .sendKeys("Chicago Midway International Airport (MDW) Chicago");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class='flatpickr-day '])[9]")).sendKeys(Keys.ENTER);
        Select date_between = new Select(driver.findElement(By.id("form-field-travel_comp_date_between")));
        date_between.selectByIndex(3);
        Select airLine = new Select(driver.findElement(By.id("form-field-travel_comp_airline")));
        airLine.selectByIndex(2);
        Select language = new Select(driver.findElement(By.id("form-field-travel_comp_language")));
        language.selectByValue("Hindi");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.xpath("//*[@id='p2u-travel-companion-wrap']/div/div[1]/div/div[1]/div[1]/h2")));

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,
                    new File("D:\\selenium_assignment\\assignment3\\src\\img\\searchResult.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void Close() {
        driver.close();
    }

}
