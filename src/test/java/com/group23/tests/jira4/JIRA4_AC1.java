package com.group23.tests.jira4;
/*
AC: 1. Verify that truck driver should be able to see
all vehicle odometer information on the grid.
 */
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JIRA4_AC1 extends JIRA4{


    @BeforeMethod @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void vehicleOdometerInfo() throws InterruptedException {
        //locating fleet menu
        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1']/a/span)[1]")).click();

        //locating vehicle odometer and clicking
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(3000);
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL,"There is no match ");

    }


    @AfterMethod @Override
    public void tearDown() throws InterruptedException {
        super.tearDown();
    }
}
