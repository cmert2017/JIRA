package com.group23.tests.jira5;
/*
4. User should be able to insert videos by clicking on the video icon and entering the video URL.
5. User should be able to create a quote by clicking on the Comma icon.
6. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JIRA5_US3_AC4 {

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

    /**
     *4. User should be able to insert videos by clicking on the video icon and
     * entering the video URL.
     */
    @Test
    public void US3_AC4() throws InterruptedException {

       /* WebElement eventTabElement = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']/span"));

        eventTabElement.click();

        Thread.sleep(3000);
        //WebElement addVideoElement = driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']/i"));
        WebElement addVideoElement = driver.findElement(By.xpath("//span[@id='bx-b-video-blogPostForm_calendar']"));
        addVideoElement.click();
*/
            WebElement eventTabElement = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']/span"));
            eventTabElement.click();
            Thread.sleep(3000);
            WebElement addVideoElement = driver.findElement(By.xpath("//span[@id='bx-b-video-blogPostForm_calendar']"));
            addVideoElement.click();
            Thread.sleep(3000);
            WebElement url = driver.findElement(By.xpath("//input[@id=\"video_oCalEditorcal_3Jcl-source\"]"));
           //test data impediment !!!!!!!
            url.sendKeys("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
            Thread.sleep(5000);
            WebElement saveButton = driver.findElement(By.xpath("//input[@id=\"undefined\"]"));
            saveButton.click();

        WebElement loadedVideo = driver.findElement(By.xpath("//img[@title=\"Video\"]"));
        Assert.assertTrue(loadedVideo.isDisplayed());
        Thread.sleep(3000);



        }


    /*@AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }*/

}
