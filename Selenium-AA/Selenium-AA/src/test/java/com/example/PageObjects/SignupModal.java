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

public class SignupModal {
    WebDriver driver;
    String word;

    public SignupModal(WebDriver driver) {
        this.driver = driver;

    }

    // --------- Xpaths ---------
    By text_signup_modal = By.xpath("//*[@id='root']/div[2]/div[4]/div/div/h1");
    By cross_btn = By.xpath("//*[@id='root']/div[2]/div[4]/button/img");
    By continue_with_google_btn = By.xpath("//*[@id='root']/div[2]/div[4]/div/div/ul/li[2]/button");
    By continue_with_facebook_btn = By.xpath("//*[@id='root']/div[2]/div[4]/div/div/ul/li[1]/button");
    By verify_google_modal = By.xpath("//*[@id='headingText']/span");
    By verify_facebook_modal = By.xpath("//*[@id='content']/span");
    By input_email_google_auth = By.xpath("//*[@id='identifierId']");
    By next_btn_google_auth = By.xpath("//*[@id='identifierNext']/div/button/div[3]");
    By input_password_google_auth = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");

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
    // Verify signup modal text when click My Feed
    public void verify_signup_modal_text_my_feed() throws InterruptedException {
        waittt(text_signup_modal);
        word = driver.findElement(text_signup_modal).getAccessibleName();
        System.out.println(word);
        Assert.assertEquals("Please sign up to access this feature", word);
    }

    // verify signup modal text when click profile icon
    public void verify_signup_modal_text_profile_icon() throws InterruptedException {
        waittt(text_signup_modal);
        word = driver.findElement(text_signup_modal).getAccessibleName();
        System.out.println(word);
        Assert.assertEquals(
                "The profile feature is only available for registered users, register today to set up your profile",
                word);
    }

    // verify signup modal text when view 10 posts
    public void verify_signup_modal_text_tenth_post() throws InterruptedException {
        waittt(text_signup_modal);
        word = driver.findElement(text_signup_modal).getAccessibleName();
        System.out.println(word);
        Assert.assertEquals("Please sign up to view more posts", word);
    }

    // verify signup modal text on clicking signup button.
    public void verify_signup_modal_text_signup_btn() {
        waittt(text_signup_modal);
        word = driver.findElement(text_signup_modal).getAccessibleName();
        System.out.println(word);
        Assert.assertEquals(
                "Get access to a wide range of content by logging in, or sign up if you do not have an account", word);
    }

    // click cross button
    public void click_cross_btn() throws InterruptedException {
        waittt(cross_btn);
        driver.findElement(cross_btn).click();
    }

    // click continue with google button and verify authentication modal
    public void click_continue_with_google_btn() {
        waittt(continue_with_google_btn);
        String mainWindow = driver.getWindowHandle();
        driver.findElement(continue_with_google_btn).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        it.next();
        String child_window = it.next();
        driver.switchTo().window(child_window);
        waittt(verify_google_modal);
        word = driver.findElement(verify_google_modal).getText();
        System.out.println(word);
        Assert.assertEquals("Sign in", word);
    }

    // click continue with facebook button and verify authentication modal
    public void click_continue_with_facebook_btn() {
        waittt(continue_with_facebook_btn);
        String mainWindow = driver.getWindowHandle();
        driver.findElement(continue_with_facebook_btn).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        it.next();
        String child_window = it.next();
        driver.switchTo().window(child_window);
        waittt(verify_facebook_modal);
        word = driver.findElement(verify_facebook_modal).getText();
        System.out.println(word);
        Assert.assertEquals("Global Drum", word);
    }

    // click continue with google and complete google authentication
    public void complete_google_authentication() {
        waittt(continue_with_google_btn);
        String mainWindow = driver.getWindowHandle();
        driver.findElement(continue_with_google_btn).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        it.next();
        String child_window = it.next();
        driver.switchTo().window(child_window);
        waittt(input_email_google_auth);
        driver.findElement(input_email_google_auth).sendKeys("utwo76476");
        waittt(next_btn_google_auth);
        driver.findElement(next_btn_google_auth).click();
        waittt(input_password_google_auth);
        driver.findElement(input_password_google_auth).sendKeys("Pupples123@");
        driver.findElement(next_btn_google_auth).click();
        driver.switchTo().window(mainWindow);
    }

    // Verify terms and condition window
    public void verify_terms_and_condition_screen() {
        waittt(continue_with_facebook_btn);
    }

}
