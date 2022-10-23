package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Q4-Open this URL(https://demoqa.com/) 
// and perofrm drag and drop,right-click using Action class 

public class Q4 {

    static WebDriver driver;
    Alert alert;
    Actions action;

    @BeforeMethod
    public void Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void drag_drop() {
        WebElement drag_Element = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop_Element = driver.findElement(By.xpath("//div[@id='droppable']"));
        action = new Actions(driver);
        action.dragAndDrop(drag_Element, drop_Element).build().perform();
        WebElement dropped_Element = driver
                .findElement(By.xpath("//*[@id='droppable' and contains(@class,'ui-state-highlight')]/p"));
        String dropped_Element_Text = dropped_Element.getText();
        Assert.assertEquals(dropped_Element_Text, "Dropped!");
    }

    @Test
    public void right_click() {
        driver.navigate().to("https://demoqa.com/buttons");
        // driver.findElement(By.xpath("//div[text() ='Elements']")).click();
        // driver.findElement(By.xpath("(//li[@id='item-4'])[1]")).click();
        WebElement right_btn = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        action = new Actions(driver);
        action.contextClick(right_btn).perform();
    }

    @AfterMethod
    public void Close() {
        driver.quit();
    }

}
