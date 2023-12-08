package com.example.TestCases.Guest_Userr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.example.PageObjects.CommunityDetails;
import com.example.PageObjects.CommunityListing;
import com.example.PageObjects.Discover;
import com.example.PageObjects.SearchObjs;
import com.example.PageObjects.SignupModal;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Search {
    // Objects
    WebDriver driver;
    Discover ds;
    CommunityListing cl;
    CommunityDetails cd;
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
    }

    public void quit() {
        driver.quit();
    }

    // Test Cases
    @Test(priority = 1)
    public void verify_open_search_screen() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.verify_open_search_screen();
        quit();
    }

    @Test(priority = 2)
    public void verify_when_open_search_displays_all_tab_by_default() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.verify_all_tab_is_opened();
        quit();
    }

    @Test(priority = 3)
    public void verify_four_communities_displays_on_all_sub_tab() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.verify_four_communities();
        quit();
    }

    @Test(priority = 4)
    public void verify_open_communities_sub_tab_on_clicking_view_all_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.click_view_all_btn();
        ss.verify_communities_sub_tab_is_opened();
        quit();
    }

    @Test(priority = 5)
    public void verify_open_community_detail_from_all_sub_tab() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.click_community_on_all_sub_tab();
        cd.verify_open_communnity_detail_screen();
        quit();
    }

    @Test(priority = 6)
    public void verify_search_on_all_sub_tab() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.verify_all_tab_is_opened();
        ss.verify_searching_community();
        quit();
    }

    @Test(priority = 7)
    public void verify_signup_modal_text_on_clicking_join_community_btn_on_communities_sub_tab()
            throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.click_communities_sub_tab_btn();
        ss.click_join_community_btn_on_communities_sub_tab_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 8)
    public void verify_search_on_communities_sub_tab() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.click_communities_sub_tab_btn();
        ss.verify_searching_community();
        quit();
    }

    @Test(priority = 9)
    public void verify_pagination() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.click_communities_sub_tab_btn();
        ss.click_pagination_community();
        cd.click_back_arrow_btn();
        ss.verify_pagination_community();
        quit();
    }

}
