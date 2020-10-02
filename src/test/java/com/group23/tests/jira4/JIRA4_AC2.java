package com.group23.tests.jira4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
AC:2. Verify that Truck driver should be able to create Vehicle odometer or cancel it.
 */
public class JIRA4_AC2 extends JIRA4{


    @BeforeMethod @Override
    public void setUp() {
        super.setUp();
    }


    @Test
    public void createVehicleOdometer() throws InterruptedException {
        //locating fleet menu
        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a/span)[1]")).click();

        //locating vehicle odometer and clicking
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(5000);
        //locating create vehicle odometer button
        driver.findElement(By.partialLinkText("Create Vehicle Odometer")).click();


        Thread.sleep(5000);
        //sending values to Odometer value box
       // driver.findElement(By.cssSelector("input[id~=custom_entity_type_OdometerValue-uid")).sendKeys("123456");
        driver.findElement(By.name("custom_entity_type[OdometerValue]")).sendKeys("123456");

        //selecting date
        driver.findElement(By.cssSelector("input[placeholder='Choose a date']")).click();

        //choosing a day
        driver.findElement(By.linkText("8")).click();

        //entering driver info
        String driverName = "Group23";
        driver.findElement(By.cssSelector("input[data-name='field__driver']")).sendKeys(driverName);

        //selecting unit
        WebElement unitElement = driver.findElement(By.xpath("(//span[@class='select2-chosen'] /..)[1]"));
        unitElement.click();

        //selecting mile
        driver.findElement(By.xpath("//div[.='miles']")).click();



        //locating plate add button
        driver.findElement(By.cssSelector("button[class='btn btn-medium add-btn']")).click();

        //selecting the plate number
        driver.findElement(By.cssSelector("tr[class='grid-row']:nth-of-type(24)")).click();

        //selecting and clicking SELECT button
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();



        //clicking save  and close button
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();




        //validating addition of new vehicle odometer
        //this part should be improved
        driver.navigate().back();
        String expectedDriverName = driverName;
        String actualDriverName = driver.findElement(By.xpath("//*[.='"+driverName+"']")).getText();


        Assert.assertEquals(expectedDriverName, actualDriverName);



    }
}
