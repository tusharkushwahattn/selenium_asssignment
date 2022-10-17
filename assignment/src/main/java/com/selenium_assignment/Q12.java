package com.selenium_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q12 {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://demo.automationtesting.in/Register.html");
        WebElement firstname = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        firstname.sendKeys("Tushar");
        WebElement lastname = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        lastname.sendKeys("Kushwaha");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("xyz@gmail.com");
        driver.findElement(By.name("signup")).click();

    }

}