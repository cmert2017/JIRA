package com.group23.tests.jira4;
/*
AC:3. Verify that truck driver should be able to delete or edit Vehicle odometer.
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JIRA4_AC3 extends JIRA4{


    @BeforeMethod  @Override
    public void setUp() {
        super.setUp();
    }





    @Test
    public void deleteVehicleOdometer() throws InterruptedException {
        //locating fleet menu
        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a/span)[1]")).click();

        //locating vehicle odometer and clicking
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        //clicking on first row
        driver.findElement(By.cssSelector("tr[class='grid-row row-click-action']")).click();


        Thread.sleep(3000);
        //catching url of the selected car
        String actualURL = driver.getCurrentUrl();


        // locating and clicking the delete button
        driver.findElement(By.xpath("//a[@title='Delete Vehicle Odometer']")).click();


        //locating and clicking on yes button on delete confirmation window
        driver.findElement(By.partialLinkText("Yes,")).click();


        driver.navigate().to(actualURL);

        String actualConfirmationMessage= driver.findElement(By.className("error-page-title")).getText();
        String expectedConfirmationMessage = "404. Not Found";

        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage, "they dont match");



        /*driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String expectedConfirmationMessage = "Vehicle Odometer deleted";
        WebElement vehicle_odometer_deleted = driver.findElement(By.linkText("Vehicle Odometer deleted"));
        String actualConfirmationMessage = vehicle_odometer_deleted.getText();
        System.out.println(actualConfirmationMessage);*/

        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage);

    }


    @AfterMethod @Override
    public void tearDown() throws InterruptedException {
        super.tearDown();
    }
}
