package com.kemal.test.selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @BeforeAll
    void beforeall(){
        System.out.println("test cases has started");
    }
    @org.testng.annotations.Test(priority = 0)
    void testtitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Stack Overflow - Where Developers Learn, Share, & Build Careers");
        driver.close();
        System.out.println("Title is = " + title);
    }
    @org.testng.annotations.Test(priority = 1)
    void getallinks(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int count = 1;
        for (WebElement element1: links) {
            if (element1.getAttribute("href").equals("javascript:void(0)") || element1.getAttribute("href").isEmpty()){
                continue;
            }
            else{
            System.out.println(count + "." + element1.getAttribute("href"));
            count++;
            }
        }
        driver.quit();
        System.out.println(count);
    }
}
