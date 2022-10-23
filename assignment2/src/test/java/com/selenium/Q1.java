package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

// Q1- Launch Firefox browser & navigate to https://rahulshettyacademy.com/AutomationPractice/
// Try to Fetch the alert popup text.
// Try to Dismiss the popup.
// Try to enter some data on an alert popup.
// Try to accept the popup.

public class Q1 {
    WebDriver driver;
    public Alert alert;

    @BeforeMethod
    public void Browser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void enter_and_fetch_some_data_on_an_alert_popup_Dismiss_Accept() {
        WebElement name_input = driver.findElement(By.xpath("//input[@id='name']"));
        driver.findElement(By.id("alertbtn")).click();
        alert = driver.switchTo().alert();
        String alert_text = alert.getText();
        System.out.println("The alert text is" + alert_text);
        Assert.assertEquals(alert_text, "Hello , share this practice page and share your knowledge");
        alert.dismiss();
        name_input.sendKeys("Tushar");
        driver.findElement(By.id("alertbtn")).click();
        alert = driver.switchTo().alert();
        String alert_text1 = alert.getText();
        System.out.println("The alert text is" + alert_text1);
        Assert.assertTrue(alert_text1.contains("Tushar"));
        alert.accept();
    }

    @AfterMethod
    public void Close() {
        driver.quit();
    }

}
