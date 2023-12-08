package com.example.TestCases.Guest_Userr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.example.PageObjects.CommunityDetails;
import com.example.PageObjects.CommunityListing;
import com.example.PageObjects.Discover;
import com.example.PageObjects.PostDetails;
import com.example.PageObjects.SearchObjs;
import com.example.PageObjects.SignupModal;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_PostDetail {
    // Objects
    WebDriver driver;
    Discover ds;
    CommunityListing cl;
    CommunityDetails cd;
    PostDetails pd;
    SignupModal sm;
    SearchObjs ss;

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
        cd = new CommunityDetails(driver);
        ss = new SearchObjs(driver);
        pd = new PostDetails(driver);
    }

    public void quit() {
        driver.quit();
    }

    // Test Cases
    @Test(priority = 1)
    public void verify_access_post_detail_screen_from_discover() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_post_card_discover();
        pd.verify_visit_website_btn_on_post_detail();
        quit();
    }

    @Test(priority = 2)
    public void verify_access_post_detail_screen_from_community_post_section() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.click_post_card();
        pd.verify_visit_website_btn_on_post_detail();
        quit();
    }

    @Test(priority = 3)
    public void verify_signup_modal_text_on_clicking_bookmark_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_post_card_discover();
        pd.click_bookmark_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 4)
    public void verify_signup_modal_text_on_clicking_like_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_post_card_discover();
        pd.click_like_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 5)
    public void verify_signup_modal_text_on_clicking_dislike_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_post_card_discover();
        pd.click_dislike_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 6)
    public void verify_signup_footer_is_displaying_and_open_signup_modal_on_click() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_post_card_discover();
        pd.verify_signup_footer();
        pd.click_signup_footer_btn();
        sm.verify_signup_modal_text_signup_btn();
        quit();
    }
}
