package com.group23.tests.jira3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JIRA3_AC2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
                  /*driver = new FirefoxDriver();
                  driver = new SafariDriver();
                 */



       // driver.manage().window().maximize();

        driver.navigate().to("https://qa2.vytrack.com/user/login");

        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys("user173");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[class='title title-level-1']")).click();
        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("tr[class='grid-row row-click-action']")).click();




        //driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(3000);
        String expectedtInUrl = "https://qa2.vytrack.com/entity/view/Extend_Entity_Carreservation/item/";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedtInUrl)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println(actualUrl);
            System.out.println(expectedtInUrl);
        }

/*
        String expectedTitle = "Texas1092 Magdalena Belgium 2019 red sedan";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println(actualTitle);
            System.out.println(expectedTitle);
        }*/




    }
}
