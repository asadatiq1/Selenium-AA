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

public class TC_CommunityLising {
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
    public void verify_open_communnity_listing_screen() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.verify_open_community_listing();
        quit();
    }

    @Test(priority = 2)
    public void verify_signup_modal_text_on_clicking_join_community_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_join_community_btn();
        sm.verify_signup_modal_text_my_feed();
        quit();
    }

    @Test(priority = 3)
    public void verify_open_category_menu_on_clicking_more_filter_on_category_filter() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_category_on_category_filter();
        cl.verify_open_category_filter_menu();
        quit();
    }

    @Test(priority = 4)
    public void verify_search_category_on_category_menu_search() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_category_on_category_filter();
        cl.verify_searched_category_on_category_menu();
        quit();
    }

    @Test(priority = 5)
    public void verify_unselect_all_categories_from_category_menu() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_category_on_category_filter();
        cl.click_all_check_box_on_category_menu();
        cl.click_cross_btn_on_category_menu();
        cl.verify_category_filter();
        quit();
    }

    @Test(priority = 6)
    public void verify_select_specific_category_from_category_menu() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_category_on_category_filter();
        cl.click_all_check_box_on_category_menu();
        cl.click_specific_category_from_catgory_menu();
        cl.verify_selected_category_on_category_filter();
        quit();
    }

    @Test(priority = 7)
    public void verify_pagination_community_listing() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_pagination_community();
        cd.click_back_arrow_btn();
        cl.verify_pagination_community_displaying();
        quit();
    }

    @Test(priority = 8)
    public void verify_open_search_from_community_listing() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_search_btn_on_community_listing();
        ss.verify_open_search_screen();
        quit();
    }

    @Test(priority = 9)
    public void verify_open_community_detail_on_clicking_community_on_community_listing() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.click_community();
        cd.verify_open_communnity_detail_screen();
        quit();
    }

    @Test(priority = 10)
    public void verify_signup_footer_is_displaying_and_open_signup_modal_on_click() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_explore_communities_btn();
        cl.verify_signup_footer();
        cl.click_signup_footer_btn();
        sm.verify_signup_modal_text_signup_btn();
        quit();
    }

}
