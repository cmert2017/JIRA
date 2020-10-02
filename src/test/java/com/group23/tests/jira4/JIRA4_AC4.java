package com.group23.tests.jira4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
Verify that truck driver should be able to reset grid by click on grid setting
 */
public class JIRA4_AC4 extends  JIRA4{


    @Test
    public void resettingGrid() throws InterruptedException {
        //locating fleet menu
        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a/span)[1]")).click();

        //locating vehicle odometer and clicking
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(3000);
       // WebElement nextButtonElements = driver.findElement(By.cssSelector("i[class='fa-chevron-right hide-text']"));
       // WebElement nextButtonElementsBefore = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']/.."));
       // WebElement nextButtonElementsBefore = driver.findElement(By.xpath("//*[@id=\"grid-custom-entity-grid-1842890950\"]/div[2]/div[1]/div/div[4]/ul/li[3]"));
      // WebElement nextButtonElementsBefore = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[4]/ul/li[3]/a"));
       WebElement nextButtonElementsBefore = driver.findElement(By.xpath("(//a[@href='#'])[24]"));
       WebElement nextButtonElementsParentBefore = driver.findElement(By.xpath("(//a[@href='#'])[24]/.."));

        while(!nextButtonElementsParentBefore.getAttribute("class").equals("disabled ")) {
            Thread.sleep(3000);
            List<WebElement> odometerElementsBefore = driver.findElements(By.cssSelector("td[class='number-cell grid-cell grid-body-cell grid-body-cell-OdometerValue']"));
            nextButtonElementsBefore = driver.findElement(By.xpath("(//a[@href='#'])[24]"));
            nextButtonElementsBefore.click();
            nextButtonElementsBefore = driver.findElement(By.xpath("(//a[@href='#'])[24]"));
            nextButtonElementsParentBefore = driver.findElement(By.xpath("(//a[@href='#'])[24]/.."));

        }
        //locating grid icon
        WebElement gridIconElement = driver.findElement(By.cssSelector("i.fa-cog.hide-text"));
        gridIconElement.click();

        WebElement pageNumberelement = driver.findElement(By.xpath("//input[@type='number']"));
        Thread.sleep(2000);
        pageNumberelement.click();
        Thread.sleep(2000);
        pageNumberelement.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        pageNumberelement.sendKeys("1");
        Thread.sleep(2000);
        pageNumberelement.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement nextButtonElementsAfter = driver.findElement(By.xpath("(//a[@href='#'])[24]"));
        WebElement nextButtonElementsParentAfter = driver.findElement(By.xpath("(//a[@href='#'])[24]/.."));

        while(!nextButtonElementsParentAfter.getAttribute("class").equals("disabled ")) {
            Thread.sleep(3000);
            List<WebElement> odometerElementsBefore = driver.findElements(By.cssSelector("td[class='number-cell grid-cell grid-body-cell grid-body-cell-OdometerValue']"));
            nextButtonElementsAfter = driver.findElement(By.xpath("(//a[@href='#'])[24]"));
            nextButtonElementsAfter.click();
            nextButtonElementsAfter = driver.findElement(By.xpath("(//a[@href='#'])[24]"));
            nextButtonElementsParentAfter = driver.findElement(By.xpath("(//a[@href='#'])[24]/.."));

        }



        Thread.sleep(5000);

    }



}
