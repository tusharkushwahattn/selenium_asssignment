package com.selenium_assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2googlesearchIE {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.get("https://www.google.com/");
    }
}