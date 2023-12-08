package com.example.PageObjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchObjs {
    WebDriver driver;
    String word;
    boolean t;

    public SearchObjs(WebDriver driver) {
        this.driver = driver;
    }

    // --------- Xpaths ---------
    By input_search = By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/div/div/form/input");
    By all_sub_tab_btn = By.xpath("//*[@id='hoverEffect-0']/button");
    By communities_sub_tab_btn = By.xpath("//*[@id='hoverEffect-1']/button");
    By view_all_btn = By.xpath("//*[@id='root']/div[2]/div[2]/div[5]/div/div[2]/div[4]/div[2]/button");
    By display_four_communities = By.xpath("//*[@class='community-card-wrapper']");
    By join_community_btn = By.xpath("//*[@id='post-0']/div/div/div[2]/button");
    By community_on_all_sub_tab = By.xpath("//*[@id='post-0']/div/div");
    By searched_community = By.xpath("//*[@id='post-0']/div/div/div/div[2]/h2");
    By pagination_community = By.xpath("//*[@id='post-8']");

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
    // verify open search screen
    public void verify_open_search_screen() throws InterruptedException {
        waiiit(input_search);
        t = driver.findElement(input_search).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // verify all_tab is opened
    public void verify_all_tab_is_opened() throws InterruptedException {
        waiiit(view_all_btn);
        t = driver.findElement(view_all_btn).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // verify only 4 communities displays on all sub tab
    public void verify_four_communities() throws InterruptedException {
        waiiit(display_four_communities);
        List<WebElement> communityCount = driver.findElements(display_four_communities);
        System.out.println(communityCount.size());
        int count = communityCount.size();
        Assert.assertEquals(4, count);
    }

    // Click view all button on about sub tab
    public void click_view_all_btn() throws InterruptedException {
        waiiit(view_all_btn);
        driver.findElement(view_all_btn).click();
    }

    // verify open communities sub tab
    public void verify_communities_sub_tab_is_opened() throws InterruptedException {
        waiiit(join_community_btn);
        t = driver.findElement(join_community_btn).isDisplayed();
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // open community on community all sub tab
    public void click_community_on_all_sub_tab() throws InterruptedException {
        waiiit(community_on_all_sub_tab);
        driver.findElement(community_on_all_sub_tab).click();
    }

    // Verify seaching community on all sub tab
    public void verify_searching_community() throws InterruptedException {
        waiiit(input_search);
        driver.findElement(input_search).sendKeys("Change");
        waiiit(searched_community);
        word = driver.findElement(searched_community).getText();
        t = word.contains("Change");
        System.out.println(t);
        Assert.assertEquals(true, t);
    }

    // Click community sub tab button
    public void click_communities_sub_tab_btn() throws InterruptedException {
        waiiit(communities_sub_tab_btn);
        driver.findElement(communities_sub_tab_btn).click();
    }

    // Click on join community community button on communities sub tab
    public void click_join_community_btn_on_communities_sub_tab_btn() throws InterruptedException {
        waiiit(join_community_btn);
        driver.findElement(join_community_btn).click();
    }

    // Click pagination
    public void click_pagination_community() throws InterruptedException {
        waiiit(pagination_community);
        scroll(pagination_community);
        driver.findElement(pagination_community).click();
    }

    // Verify pagination community
    public void verify_pagination_community() throws InterruptedException {
        waiiit(pagination_community);
        t = driver.findElement(pagination_community).isDisplayed();
        Assert.assertEquals(true, t);
    }

}
