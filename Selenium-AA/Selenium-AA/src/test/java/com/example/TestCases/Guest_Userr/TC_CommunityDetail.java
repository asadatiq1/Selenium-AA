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

public class TC_CommunityDetail {
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
    public void verify_access_to_community_detail() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.verify_open_communnity_detail_screen();
        quit();
    }

    @Test(priority = 2)
    public void verify_community_about_sub_tab_is_opened_by_default() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.verify_community_about_sub_tab();
        quit();
    }

    @Test(priority = 3)
    public void verify_toast_on_clicking_community_apps_sub_tab() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_community_app();
        quit();
    }

    @Test(priority = 4)
    public void verify_signup_modal_on_clicking_join_community_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_join_community_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 5)
    public void verify_signup_modal_text_on_clicking_profile_icon_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_profile_icon_btn();
        sm.verify_signup_modal_text_profile_icon();
        quit();
    }

    @Test(priority = 6)
    public void verify_open_post_section_of_community_detail_screen() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.verify_open_post_sub_tab();
        quit();
    }

    @Test(priority = 7)
    public void verify_open_post_detail_on_clicking_post_card() throws InterruptedException {
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

    @Test(priority = 8)
    public void verify_signup_modal_text_on_clicking_bookmark_btn_on_post_card() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.click_bookmark_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 9)
    public void verify_signup_modal_text_on_clicking_like_btn_on_post_card() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.click_like_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 10)
    public void verify_signup_modal_text_on_clicking_dislike_btn_on_post_card() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.click_dislike_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 11)
    public void verify_signup_modal_text_on_viewing_limited_content() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.scroll_to_last();
        sm.verify_signup_modal_text_tenth_post();
        quit();
    }

    @Test(priority = 12)
    public void verify_pagination() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.click_post_sub_tab_btn();
        cd.scroll_to_last();
        sm.click_cross_btn();
        cd.click_pagination_post();
        pd.click_back_arrow_btn();
        sm.click_cross_btn();
        cd.verify_pagination();
        quit();
    }

    @Test(priority = 13)
    public void verify_signup_footer_is_displaying_and_open_signup_modal_on_click() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.verify_signup_footer();
        cd.click_signup_footer_btn();
        sm.verify_signup_modal_text_signup_btn();
        quit();
    }
}
