package com.example.TestCases.Guest_Userr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.example.PageObjects.CommunityListing;
import com.example.PageObjects.Discover;
import com.example.PageObjects.SideMenu;
import com.example.PageObjects.SignupModal;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SideMenu {
    // Objects
    WebDriver driver;
    Discover ds;
    CommunityListing cl;
    SignupModal sm;
    SideMenu smm;

    // Setups
    public void setup() {
        // setup
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        // visit website
        driver.get("https://www.aa-stage.global-drum.com/");

        // Initializing Objects
        ds = new Discover(driver);
        cl = new CommunityListing(driver);
        sm = new SignupModal(driver);
        smm = new SideMenu(driver);
    }

    public void quit() {
        driver.quit();
    }

    // Test Cases
    @Test(priority = 1)
    public void verify_access_side_menu_from_discover() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_side_menu();
        smm.verify_open_side_menu();
        quit();
    }

    @Test(priority = 2)
    public void verify_access_side_menu_from_community_listing() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_side_menu();
        smm.verify_open_side_menu();
        quit();
    }

    @Test(priority = 3)
    public void verify_guest_user_text_on_side_menu() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_side_menu();
        smm.verify_guest_user_text();
        quit();
    }

    @Test(priority = 4)
    public void verify_community_listing_on_clicking_communities_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_side_menu();
        smm.click_communities_btn();
        cl.verify_open_community_listing();
        quit();
    }

    @Test(priority = 5)
    public void verify_signup_modal_text_on_clickinh_signup_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_side_menu();
        smm.click_signup_btn();
        sm.verify_signup_modal_text_signup_btn();
        quit();
    }
}
