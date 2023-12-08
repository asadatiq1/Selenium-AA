package com.example.PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideMenu {
    WebDriver driver;
    String word;
    boolean t;

    public SideMenu(WebDriver driver) {
        this.driver = driver;
    }

    // --------- Xpaths ---------
    By verify_side_menu = By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div");
    By text_guest_user = By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/p");
    By communities_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/ul/li[2]/a");
    By signup_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/ul/li[3]/span");

    // --------- Genral ---------

    // wait untill the element is found
    public void waittt(By yy) {
        WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement aboutMe;
        aboutMe = webdwait.until(ExpectedConditions.visibilityOfElementLocated(yy));
    }

    // scroll into view
    public void scroll(By scrol) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(scrol);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    // --------- Methods ---------
    // verify side menu is opened
    public void verify_open_side_menu() {
        waittt(verify_side_menu);
        t = driver.findElement(verify_side_menu).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // verify guest user text on side menu
    public void verify_guest_user_text() {
        waittt(text_guest_user);
        word = driver.findElement(text_guest_user).getText();
        System.out.println(word);
        Assert.assertEquals("Guest User", word);
    }

    // click communities button
    public void click_communities_btn() {
        waittt(communities_btn);
        driver.findElement(communities_btn).click();
    }

    // click signup button
    public void click_signup_btn() {
        waittt(signup_btn);
        driver.findElement(signup_btn).click();
    }
}
