package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

// 2. Go to TTN website https://www.tothenew.com/ 
// and verify the options under Services dropdown

public class Q2 {
    public WebDriver driver;
    public Actions action;

    @BeforeMethod
    public void Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.tothenew.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action = new Actions(driver);
    }

    @Test
    public void Verify_Options_in_Service_DropDown() {
        action = new Actions(driver);
        WebElement service = driver.findElement(By.xpath("(//a[@id='h-Services'])[2]"));
        action.moveToElement(service).perform();
        List<WebElement> ServiceDropDown = driver
                .findElements(By.xpath("(//li[@class='menu-item menu-expanded'])[4]//ul/li"));
        for (int i = 0; i < ServiceDropDown.size(); i++) {
            System.out.println(ServiceDropDown.get(i).getText());
            System.out.println("*********************************");
        }
        String S1 = ServiceDropDown.get(0).getText();
        String S2 = ServiceDropDown.get(1).getText();
        String S3 = ServiceDropDown.get(2).getText();
        String S4 = ServiceDropDown.get(3).getText();
        String S5 = ServiceDropDown.get(4).getText();
        String S6 = ServiceDropDown.get(5).getText();

        Assert.assertEquals(S1, "Digital Engineering");
        Assert.assertEquals(S2, "Cloud & DevOps");
        Assert.assertEquals(S3, "OTT Solutions & Services");
        Assert.assertEquals(S4, "Data & Analytics");
        Assert.assertEquals(S5, "CX, Content & Commerce");
        Assert.assertEquals(S6, "Digital Marketing");

    }

    @AfterMethod
    public void Close() {
        driver.close();
    }

}
