package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//1. Go to https://demo.automationtesting.in/Register.html and 
//fill all the details in the form and click on submit button. 
public class Q1 {
    static WebDriver driver;

    @BeforeClass
    public void Initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void FillTextBox() {
        WebElement FirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        FirstName.sendKeys("Tushar");
        WebElement LastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        LastName.sendKeys("Kushwaha");
        WebElement Address = driver.findElement(By.xpath("//textarea[@rows='3']"));
        Address.sendKeys("Sector 44 Noida");
        WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
        Email.sendKeys("tusharkushwaha@gmail.com");
        WebElement PhoneNo = driver.findElement(By.xpath("//input[@type='tel']"));
        PhoneNo.sendKeys("9988776655");
        WebElement Pass1 = driver.findElement(By.xpath("//input[@id='firstpassword']"));
        Pass1.sendKeys("pass123");
        WebElement Pass2 = driver.findElement(By.xpath("//input[@id='secondpassword']"));
        Pass2.sendKeys("pass123");
    }

    @Test(priority = 2)
    public void HandleRadioAndCheckbox() {
        // Check all Hobbies
        List<WebElement> Hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < Hobbies.size(); i++) {
            Hobbies.get(i).click();
        }
        // Select Male Radio Button
        List<WebElement> Gender = driver.findElements(By.xpath("//input[@type='radio']"));
        Gender.get(0).click();
        boolean GenderSelect = driver.findElement(By.xpath("//input[@value='Male']")).isSelected();
        Assert.assertTrue(GenderSelect);
    }

    @Test(priority = 3)
    public void HandleDropdowns() {
        WebElement Skills = driver.findElement(By.id("Skills"));
        Select se = new Select(Skills);
        se.selectByVisibleText("Java");

        WebElement SelectCountry = driver.findElement(By.id("country"));
        se = new Select(SelectCountry);
        se.selectByVisibleText("India");

        driver.findElement(By.id("msdd")).click();
        List<WebElement> Language = driver.findElements(By
                .xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
        Language.get(7).click();

        WebElement Year = driver.findElement(By.id("yearbox"));
        se = new Select(Year);
        se.selectByVisibleText("2000");

        WebElement Month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        se = new Select(Month);
        se.selectByVisibleText("April");

        WebElement Day = driver.findElement(By.id("daybox"));
        se = new Select(Day);
        se.selectByVisibleText("19");
    }

    @Test(priority = 4)
    public void Submit() {
        WebElement SubmitBtn = driver.findElement(By.id("submitbtn"));
        SubmitBtn.click();
    }
}