package com.group23.tests.jira3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
AC 3. Verify that truck driver can add Event and
it should display under Activity tab and
General information page as well .
 */
public class JIRA3_AC3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys("user173");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("UserUser123"+ Keys.ENTER);

        //with a problem it finds fleet
        // driver.findElement(By.cssSelector("span[class='title title-level-1']")).click();
        //driver.findElement(By.linkText("Vehicles")).click();


       //with css it finds fleet
        // driver.findElement(By.cssSelector("li[class='dropdown dropdown-level-1']:nth-of-type(1)")).click();
        //driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        driver.findElement(By.cssSelector("span.title.title-level-1:nth-of-type(1)")).click();

        //finding vehicle not working properly
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]")).click();
        //sometimes it works sometimes throws the following: org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <tr class="grid-row row-click-action">...</tr> is not clickable at point (584, 257). Other element would receive the click:


        //driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']/div/div/ul/li[3]/a")).click();
        // above one throws : org.openqa.selenium.NoSuchWindowException: no such window: target window already closed



        //driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']//span)[4]")).click();


        //finding vehicle working
        // driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/div/div/ul/li[3]/a/span)[1]")).click();

        //driver.findElement(By.linkText("Vehicles")).click();
        //driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']")).click();
        //driver.findElement(By.cssSelector("span.title.title-level-2")).click();

       //driver.findElement(By.cssSelector("tr[class='grid-row row-click-action']")).click();
        driver.findElement(By.xpath("(//tr[contains(@class, 'grid-row') and contains(@class,'row-click-action')])[1]")).click();
            // sample: //a[contains(@class, 'current') and contains(@class, 'time')]

        //driver.findElement(By.cssSelector("tr.grid-row.row-click-action:nth-of-type(1)")).click();
        //throws sometimes: org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <tr class="grid-row row-click-action">...</tr> is not clickable at point (584, 257).


        driver.findElement(By.xpath("//a[@title='Add an event to this record']")).click();



        //filling add event form
        WebElement titleElement = driver.findElement(By.xpath("(//input[contains(@id,'oro_')])[1]"));
        titleElement.sendKeys("Oil change");


        WebElement organizerDisplayNameElement = driver.findElement(By.xpath("//input[contains(@data-name,'organizer-display')]"));
        organizerDisplayNameElement.sendKeys("Truck Driver");


        WebElement organizerEmailElement = driver.findElement(By.xpath("//input[contains(@data-name,'organizer-email')]"));
        organizerEmailElement.sendKeys("truckdriver@gmail.com");


       /* //WebElement startDateElement = driver.findElement(By.xpath("(//span[@style='display:none']/input)[1]"));
        WebElement startDateElement = driver.findElement(By.xpath("//span[@style='display:none']"));
        startDateElement.click();
        WebElement DateElement1 = driver.findElement(By.xpath("//*[.='Today']"));
        DateElement1.click();

        WebElement endDateElement = driver.findElement(By.xpath("(//span[@style='display:none']/input)[1]"));
        endDateElement.click();
        WebElement DateElement2 = driver.findElement(By.xpath("//*[.='Today']"));
        DateElement2.click();*/

        WebElement saveButtonElement = driver.findElement(By.xpath("//button[.='Save']"));
        saveButtonElement.click();
        //verification of add event:


       // driver.close();


    }
}
















