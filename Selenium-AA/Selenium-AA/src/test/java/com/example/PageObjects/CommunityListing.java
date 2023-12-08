package com.example.PageObjects;

import java.time.Duration;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityListing {
    WebDriver driver;
    String word;
    boolean t;

    public CommunityListing(WebDriver driver) {
        this.driver = driver;
    }

    // --------- Xpaths ---------
    By verify_page = By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/div/h1");
    By join_community_btn = By.xpath("//*[@id='post-0']/div/div/div[2]/button");
    By filter_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[1]/div/div/div/div[15]/span/span");
    By verify_category_menu = By.xpath("/html/body/div[3]/div/div/div[1]/div[1]/h2");
    By input_search = By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/input");
    By category_search_result = By.xpath("/html/body/div[3]/div/div/div[2]/div/div/label");
    By all_check_box = By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/label");
    By cross_btn_category_menu = By.xpath("/html/body/div[3]/div/div/div[1]/div[1]/span/img");
    By choose_category_category_menu = By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/label");
    By selected_category_category_filter = By
            .xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[1]/div/div/div/div[1]/span/span[1]");
    By pagination_community = By.xpath("//*[@id='post-10']");
    By search_btn = By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/button/img");
    By community = By.xpath("//*[@id='post-1']/div/div/div[1]/div[2]");
    By verify_signup_footer = By.xpath("//*[@id='root']/div[2]/div[2]/div[6]");
    By signup_footer_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[6]/div/div/button");
    By side_menu_btn = By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/div/button/img[1]");

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
    // verify communities heading on community listing
    public void verify_open_community_listing() throws InterruptedException {
        waiiit(verify_page);
        word = driver.findElement(verify_page).getText();
        System.out.println(word);
        Assert.assertEquals("Communities", word);
    }

    // click join community button
    public void click_join_community_btn() throws InterruptedException {
        waiiit(join_community_btn);
        driver.findElement(join_community_btn).click();
    }

    // click more filter on the category filter
    public void click_category_on_category_filter() throws InterruptedException {
        waiiit(filter_btn);
        driver.findElement(filter_btn).click();
    }

    // verify open category filter on community listing screen
    public void verify_open_category_filter_menu() throws InterruptedException {
        waiiit(verify_category_menu);
        word = driver.findElement(verify_category_menu).getAccessibleName();
        System.out.println(word);
        Assert.assertEquals("Categories", word);
    }

    // Enter category name in the category menu search and verify the result
    public void verify_searched_category_on_category_menu() throws InterruptedException {
        waiiit(input_search);
        driver.findElement(input_search).sendKeys("Health");
        waiiit(category_search_result);
        word = driver.findElement(category_search_result).getText();
        System.out.println(word);
        Assert.assertEquals("Health and Fitness (1)", word);
    }

    // click all check box on category menu
    public void click_all_check_box_on_category_menu() throws InterruptedException {
        waiiit(all_check_box);
        driver.findElement(all_check_box).click();
    }

    // click cross btn on category menu
    public void click_cross_btn_on_category_menu() throws InterruptedException {
        waiiit(cross_btn_category_menu);
        driver.findElement(cross_btn_category_menu).click();
    }

    // verify category filter menu is open
    public void verify_category_filter() {
        t = driver.findElement(verify_category_menu).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // click specific category from the category menu
    public void click_specific_category_from_catgory_menu() throws InterruptedException {
        waiiit(choose_category_category_menu);
        driver.findElement(choose_category_category_menu).click();
    }

    // verify selected category on category filter
    public void verify_selected_category_on_category_filter() throws InterruptedException {
        waiiit(selected_category_category_filter);
        word = driver.findElement(selected_category_category_filter).getText();
        System.out.println(word);
        Assert.assertEquals("Artificial Intelligence", word);
    }

    // open pagination community
    public void click_pagination_community() throws InterruptedException {
        waiiit(pagination_community);
        scroll(pagination_community);
        driver.findElement(pagination_community).click();
    }

    // verify pagination community displays
    public void verify_pagination_community_displaying() throws InterruptedException {
        waiiit(pagination_community);
        t = driver.findElement(pagination_community).isDisplayed();
        Assert.assertEquals(true, t);
    }

    // click search button on community listing
    public void click_search_btn_on_community_listing() throws InterruptedException {
        waiiit(search_btn);
        driver.findElement(search_btn).click();
    }

    // click community on community listing
    public void click_community() throws InterruptedException {
        waiiit(community);
        driver.findElement(community).click();
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

    // Click side menu
    public void click_side_menu() throws InterruptedException {
        waiiit(side_menu_btn);
        driver.findElement(side_menu_btn).click();
    }
}
