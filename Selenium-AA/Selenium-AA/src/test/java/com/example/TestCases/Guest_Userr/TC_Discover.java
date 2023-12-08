package com.example.TestCases.Guest_Userr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.example.PageObjects.CommunityListing;
import com.example.PageObjects.Discover;
import com.example.PageObjects.PostDetails;
import com.example.PageObjects.SignupModal;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Discover {
    // Objects
    WebDriver driver;
    Discover ds;
    PostDetails pd;
    CommunityListing cl;
    SignupModal sm;

    // Setups
    public void setup() {
        // setup
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        // visit website
        driver.get("https://www.aa-stage.global-drum.com/");

        // Initializing Objects
        ds = new Discover(driver);
        pd = new PostDetails(driver);
        cl = new CommunityListing(driver);
        sm = new SignupModal(driver);
    }

    public void quit() {
        driver.quit();
    }

    // Test Cases
    @Test(priority = 1)
    public void verify_signup_modal_text_on_clicking_My_Feed_tab() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_my_feed_tab();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 2)
    public void verify_signup_modal_text_on_clicking_profile() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_profile_icon_discover();
        sm.verify_signup_modal_text_profile_icon();
        quit();
    }

    @Test(priority = 3)
    public void verify_post_detail_screen_on_clicking_post_card_on_discover() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_post_card_discover();
        pd.verify_visit_website_btn_on_post_detail();
        quit();
    }

    @Test(priority = 4)
    public void verify_signup_modal_text_on_clicking_bookmark_btn_on_post_card() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_bookmark_btn_on_post_card();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 5)
    public void verify_open_community_listing_on_clicking_explore_communities_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.verify_open_community_listing();
        quit();
    }

    @Test(priority = 6)
    public void verify_signup_modal_text_when_view_10_posts() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.scroll_to_tenth_post();
        sm.verify_signup_modal_text_tenth_post();
        quit();
    }

    @Test(priority = 7)
    public void verify_signup_footer_is_displaying_and_open_signup_modal_on_click() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.verify_signup_footer();
        ds.click_signup_footer_btn();
        sm.verify_signup_modal_text_signup_btn();
        quit();
    }
}
