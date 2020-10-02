package com.group23.tests.jira3;

import com.group23.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Test {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        // if some time the maximize working we can use this one
        /*ChromeOptions options = new ChromeOptions();
          options.addArguments("startmaximized"); */
        /*• driver.get() à To open an URL and it will wait till the whole page gets loaded
          • driver.navigateto() à To navigate to an URL and it will not wait till the whole page get loaded */
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        //. go to the  https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");
        //Enter user name, password and login
        driver.findElement(By.id("prependedInput")).sendKeys("user152");
        //driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
    }

    @org.testng.annotations.Test
    public void fleet_verification() throws InterruptedException {
        // the XPath locators will click the vehicle odometer  under fleet module
        driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();
        //Thread.sleep(3000);
        // the XPath locators will click the vehicle odometer  under fleet module
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span")).click();
        Thread.sleep(4000);
        // the XPath locators will click the create vehicle odometer
        driver.findElement(By.xpath("//div/div/a[@title='Create Vehicle Odometer']")).click();
        Thread.sleep(6000);
        // the XPath locators will get Odometer Value  element
        //driver.findElement(By.xpath("//div[@class='control-label wrap']/i"));
        //driver.findElement(By.xpath("//input[@id='custom_entity_type_OdometerValue-uid-5f669b0f9c2ae']")).sendKeys("123456");
        driver.findElement(By.xpath("(//div[@class='controls']/input)[1]")).sendKeys("123456");
        ////li/a/span[@class='title title-level-1']
        //System.out.println("ashe");

        driver.findElement(By.xpath("//input[@placeholder='Choose a date']")).click();
        driver.findElement(By.linkText("2")).click();

        /*
       int x = driver.findElements(By.tagName("a")).size();
       System.out.println(x);
*/
    }
    /* @Test
      public void vehicle_odometers_verification() {
         Select simpleSelect = new Select(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span")));
         String actualSimple = simpleSelect.getFirstSelectedOption().getText();
         String expectedSimple = "Please select an option";
      }*/
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }



}
