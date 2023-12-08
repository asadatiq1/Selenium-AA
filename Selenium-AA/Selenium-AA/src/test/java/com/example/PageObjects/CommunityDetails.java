package com.example.PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityDetails {
    WebDriver driver;
    String word;
    boolean t;

    public CommunityDetails(WebDriver driver) {
        this.driver = driver;
    }

    // --------- Xpaths ---------
    By back_arrow_btn = By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/div/div/button/img");
    By join_community_btn = By
            .xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[2]/div[1]/button");
    By verify_community_about_sub_tab = By
            .xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/h2");
    By error_toast_community_app_sub_tab = By.className("Toastify__toast");
    By community_apps_sub_tab_btn = By.xpath("//*[@id='hoverEffect-2']/button");
    By profile_icon_btn = By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div/img");
    By post_sub_tab_btn = By.xpath("//*[@id='hoverEffect-0']/button");
    By post_card = By.xpath("//*[@id='communityPosts-0']/div");
    By bookmark_btn = By.xpath("//*[@id='communityPosts-0']/ul/span[1]");
    By like_btn = By.xpath("//*[@id='communityPosts-0']/ul/span[2]/li[1]/span/span[1]/img");
    By dislike_btn = By.xpath("//*[@id='communityPosts-0']/ul/span[2]/li[1]/span/span[2]/img");
    By last_post = By.xpath("//*[@id='communityPosts-2']");
    By verify_signup_footer = By.xpath("//*[@id='root']/div[2]/div[2]/div[6]");
    By signup_footer_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[6]/div/div/button");

    // --------- Genral ---------
    // wait untill the element is found
    public void waiiit(By yy) throws InterruptedException {
        Thread.sleep(6000);
        WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
    // click back arrow button
    public void click_back_arrow_btn() throws InterruptedException {
        waiiit(back_arrow_btn);
        driver.findElement(back_arrow_btn).click();
    }

    // verify community detail screen is opened
    public void verify_open_communnity_detail_screen() throws InterruptedException {
        waiiit(join_community_btn);
        t = driver.findElement(join_community_btn).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // Verify community about sub tab is opened
    public void verify_community_about_sub_tab() throws InterruptedException {
        waiiit(verify_community_about_sub_tab);
        word = driver.findElement(verify_community_about_sub_tab).getText();
        System.out.println(word);
        Assert.assertEquals("Community Info", word);
    }

    // Click community app sub tab and verify toast
    public void click_community_app() throws InterruptedException {
        waiiit(community_apps_sub_tab_btn);
        driver.findElement(community_apps_sub_tab_btn).click();
        Thread.sleep(2000);
        t = driver.findElement(error_toast_community_app_sub_tab).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // Click join community button
    public void click_join_community_btn() throws InterruptedException {
        waiiit(join_community_btn);
        driver.findElement(join_community_btn).click();
    }

    // Click user profile icon button
    public void click_profile_icon_btn() throws InterruptedException {
        waiiit(profile_icon_btn);
        driver.findElement(profile_icon_btn).click();
    }

    // click post sub tab button
    public void click_post_sub_tab_btn() throws InterruptedException {
        waiiit(post_sub_tab_btn);
        driver.findElement(post_sub_tab_btn).click();
    }

    // verify post sub tab is opened
    public void verify_open_post_sub_tab() throws InterruptedException {
        waiiit(post_card);
        t = driver.findElement(post_card).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // Click post card to open post detail screen
    public void click_post_card() throws InterruptedException {
        waiiit(post_card);
        driver.findElement(post_card).click();
    }

    // Click bookmark button
    public void click_bookmark_btn() throws InterruptedException {
        waiiit(bookmark_btn);
        scroll(post_card);
        driver.findElement(bookmark_btn).click();
    }

    // Click like button
    public void click_like_btn() throws InterruptedException {
        waiiit(like_btn);
        scroll(post_card);
        driver.findElement(like_btn).click();
    }

    // Click dislike button
    public void click_dislike_btn() throws InterruptedException {
        waiiit(dislike_btn);
        scroll(post_card);
        driver.findElement(dislike_btn).click();
    }

    // Scroll to the last post
    public void scroll_to_last() throws InterruptedException {
        waiiit(last_post);
        scroll(last_post);
    }

    // open pagination post
    public void click_pagination_post() throws InterruptedException {
        waiiit(last_post);
        driver.findElement(last_post).click();
    }

    // verify pagination post
    public void verify_pagination() throws InterruptedException {
        waiiit(last_post);
        t = driver.findElement(last_post).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
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
