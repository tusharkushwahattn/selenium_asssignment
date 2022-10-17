package com.selenium_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q4contactus {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.tothenew.com/");
        driver.findElement(By.xpath("(//a[text()='contact us'])[2]")).click();
        driver.navigate().back();
        driver.findElement(By.id("h-contact-us")).click();
    }

}
