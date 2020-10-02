package com.group23.tests.jira3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
AC 1. Verify that truck driver should be able to see
all Vehicle information once navigate to Vehicle page.
 */
public class JIRA3_AC1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();


        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.xpath("//input[@placeholder='Username or Email']")).sendKeys("user173"+Keys.TAB);



        Thread.sleep(5000);
        driver.quit();

    }
}
