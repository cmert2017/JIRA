package com.group23.tests.jira5;

    //login2.nextbasecrm.com

    //As a user, I should be able to create events by clicking on Event tab under Activity Stream


    //AC10-User should be able to add attendees by selecting contacts individually or
    // adding grups and departments.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JIRA5_US3_AC10 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/");

        //driver.findElement(By.xpath("//input[@class='login-inp' and @placeholder='Login']"));
        WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        inputElement.sendKeys("hr23@cybertekschool.com");



        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordElement.sendKeys("UserUser");


        WebElement LoginElement = driver.findElement(By.xpath("//input[@type='submit']"));
        LoginElement.click();


    }


    @Test
    public void US3_AC10_AddingDepartments() throws InterruptedException {

        WebElement eventElement = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventElement.click();

        Thread.sleep(3000);
        WebElement addElement = driver.findElement(By.xpath("(//a[.='Add persons, groups or department'])[1]"));
        addElement.click();

        Thread.sleep(3000);
        WebElement employeesAndDepartmentsElement = driver.findElement(By.xpath("//a[@id='destDepartmentTab_calnAJEM3']"));
        employeesAndDepartmentsElement.click();

        List<WebElement> allLinksElements = driver.findElements(By.xpath("(//div[@class='bx-finder-company-department-employees'])[2]//a"));

        String expected="";
       // System.out.println("allLinksElements.get(0).getText() = " + allLinksElements.get(0).getText());


        for (WebElement eachLink : allLinksElements) {

            if(eachLink.getText().contains("@")){
             System.out.println(eachLink.getText()+ " is added");
             List<WebElement> expecteds=  eachLink.findElements(By.xpath("//div[@class='bx-finder-company-department-employee-name']"));
             expected = expecteds.get(0).getText();
                //expected = driver.findElement(By.xpath(eachLink + "/div/div")).getText();
                //expected = eachLink.getText();
                eachLink.click();
                break;
            }

        }

        Thread.sleep(3000);
        //String actual = driver.findElement(By.xpath("//span[.='"  + expected + "']")).getText();
        String actual= driver.findElement(By.xpath("//span[@class='feed-event-destination-text']")).getText();

       // String actual = driver.findElement(By.xpath("//span[.='  "  + " hr7@cybertekschool.com  "  +  " ']")).getText();

        Assert.assertEquals(actual, expected,"the selected one and the appeared are not same");

    }


    @Test
    public void US3_AC10_AddingIndividuals() throws InterruptedException {

        WebElement eventElement = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventElement.click();

        Thread.sleep(3000);
        WebElement addElement = driver.findElement(By.xpath("(//a[.='Add persons, groups or department'])[1]"));
        addElement.click();

        Thread.sleep(5000);
        WebElement employeesAndDepartmentsElement = driver.findElement(By.xpath("//a[@id='destDepartmentTab_calnAJEM3']"));
        employeesAndDepartmentsElement.click();

        List<WebElement> allLinksElements = driver.findElements(By.xpath("(//div[@class='bx-finder-company-department-employees'])[2]//a"));

        String expected="";
        // System.out.println("allLinksElements.get(0).getText() = " + allLinksElements.get(0).getText());


        for (WebElement eachLink : allLinksElements) {

            if(!eachLink.getText().contains("@") && !eachLink.getText().contains("Group")){
                System.out.println(eachLink.getText()+ " is added");
             // List<WebElement> expecteds=  eachLink.findElements(By.xpath("//div[@class='bx-finder-company-department-employee-name']"));
                // expected = expecteds.get(0).getText();
                expected = eachLink.getText().trim();
                System.out.println("expected = " + expected);
                //expected = driver.findElement(By.xpath(eachLink + "/div/div")).getText();
                //expected = eachLink.getText();
                eachLink.click();
                break;
            }

        }


        Thread.sleep(3000);
        //String actual = driver.findElement(By.xpath("//span[.='"  + expected + "']")).getText();
        String actual= driver.findElement(By.xpath("//span[@class='feed-event-destination-text']")).getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);


        // String actual = driver.findElement(By.xpath("//span[.='  "  + " hr7@cybertekschool.com  "  +  " ']")).getText();

       Assert.assertEquals(actual, expected,"the selected one and the appeared are not same");


    }

    @Test
    public void US3_AC10_AddingGroups() throws InterruptedException {

        WebElement eventElement = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventElement.click();

        Thread.sleep(3000);
        WebElement addElement = driver.findElement(By.xpath("(//a[.='Add persons, groups or department'])[1]"));
        addElement.click();

        Thread.sleep(5000);
        WebElement employeesAndDepartmentsElement = driver.findElement(By.xpath("//a[@id='destDepartmentTab_calnAJEM3']"));
        employeesAndDepartmentsElement.click();

        List<WebElement> allLinksElements = driver.findElements(By.xpath("(//div[@class='bx-finder-company-department-employees'])[2]//a"));

        String expected="";
        // System.out.println("allLinksElements.get(0).getText() = " + allLinksElements.get(0).getText());


        for (WebElement eachLink : allLinksElements) {

            if(eachLink.getText().contains("Group")){
                System.out.println(eachLink.getText()+ " is added");
                // List<WebElement> expecteds=  eachLink.findElements(By.xpath("//div[@class='bx-finder-company-department-employee-name']"));
                // expected = expecteds.get(0).getText();
                expected = eachLink.getText().trim();
                System.out.println("expected = " + expected);
                //expected = driver.findElement(By.xpath(eachLink + "/div/div")).getText();
                //expected = eachLink.getText();
                eachLink.click();
                break;
            }

        }


        Thread.sleep(3000);
        //String actual = driver.findElement(By.xpath("//span[.='"  + expected + "']")).getText();
        String actual= driver.findElement(By.xpath("//span[@class='feed-event-destination-text']")).getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);


        // String actual = driver.findElement(By.xpath("//span[.='  "  + " hr7@cybertekschool.com  "  +  " ']")).getText();

        Assert.assertEquals(actual, expected,"the selected one and the appeared are not same");


    }




    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

}
