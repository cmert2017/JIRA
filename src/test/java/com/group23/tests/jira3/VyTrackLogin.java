package com.group23.tests.jira3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackLogin {


    public static void main(String[] args) throws InterruptedException {

       // System.setProperty("webdriver.chromedriver", "chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver =  new ChromeDriver();

        driver.manage().window().maximize();



        //go to Vytrak login page
        String URL = "https://qa2.vytrack.com/user/login";
        driver.get(URL);


//      WebElement inputElement = driver.findElement(By.id("prependedInput"));
//      inputElement.sendKeys("user173");

        //entering username
        driver.findElement(By.id("prependedInput")).sendKeys("user173");


        //entering password
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");


        //clicking on login button
        //driver.findElement(By.name("_submit")).click();
        driver.findElement(By.cssSelector(".btn.btn-uppercase.btn-primary.pull-right")).click();

        //click on fleet module
        //driver.findElement(By.cssSelector("a.unclickable>span>i")).click();
        //driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]")).click();
        driver.findElement(By.cssSelector("span[class='title title-level-1']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        //click on vehicle submenu
       // driver.findElement(By.cssSelector(".title.title-level-2")).click();

        //login out
        //driver.findElement(By.cssSelector("#user-menu > ul > li.last > a")).click();





    }

}
