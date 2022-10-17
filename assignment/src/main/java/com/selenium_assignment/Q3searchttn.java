package com.selenium_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3searchttn {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get(" https://www.google.com/");
        WebElement input_box = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        input_box.sendKeys("To The New");
        input_box.click();
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();

    }

}
