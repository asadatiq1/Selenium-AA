package com.example.PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostDetails {
    WebDriver driver;
    String word;
    boolean t;
    Set s;

    public PostDetails(WebDriver driver) {
        this.driver = driver;
    }

    // --------- Xpaths ---------
    By visit_website_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[2]/a/button");
    By back_arrow_btn = By.xpath("//*[@id='root']/div[1]/div[1]/div[1]/div/div/button");
    By bookmark_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[3]/ul/span[1]");
    By like_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[3]/ul/span[2]/li[1]/span/span[1]/img");
    By dislike_btn = By
            .xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[3]/ul/span[2]/li[1]/span/span[2]/img");
    By verify_signup_footer = By.xpath("//*[@id='root']/div[2]/div[2]/div[6]");
    By signup_footer_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[6]/div/div/button");

    // --------- Genral ---------
    // wait untill the element is found
    public void waiiit(By yy) throws InterruptedException {
        Thread.sleep(4000);
        WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aboutMe;
        aboutMe = webdwait.until(ExpectedConditions.elementToBeClickable(yy));
    }

    // scroll into view
    public void scroll(By scrol) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(scrol);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    // --------- Methods ---------
    // verify visit website button on profile detail screen
    public void verify_visit_website_btn_on_post_detail() throws InterruptedException {
        waiiit(visit_website_btn);
        t = driver.findElement(visit_website_btn).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // click back arrow button
    public void click_back_arrow_btn() throws InterruptedException {
        waiiit(back_arrow_btn);
        driver.findElement(back_arrow_btn).click();
    }

    // click bookmark button
    public void click_bookmark_btn() throws InterruptedException {
        waiiit(bookmark_btn);
        driver.findElement(bookmark_btn).click();
    }

    // click like button
    public void click_like_btn() throws InterruptedException {
        waiiit(like_btn);
        driver.findElement(like_btn).click();
    }

    // click dislike button
    public void click_dislike_btn() throws InterruptedException {
        waiiit(dislike_btn);
        driver.findElement(dislike_btn).click();
    }

    // Verify signup footer is visible
    public void verify_signup_footer() throws InterruptedException {
        waiiit(verify_signup_footer);
        t = driver.findElement(verify_signup_footer).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // click signup footer button
    public void click_signup_footer_btn() throws InterruptedException {
        waiiit(signup_footer_btn);
        driver.findElement(signup_footer_btn).click();
    }
}
