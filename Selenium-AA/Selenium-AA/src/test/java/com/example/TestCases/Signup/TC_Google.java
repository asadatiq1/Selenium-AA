package com.example.TestCases.Signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.example.PageObjects.Discover;
import com.example.PageObjects.SignupModal;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Google {
    // Objects
    WebDriver driver;
    Discover ds;
    SignupModal sm;

    // Setups
    public void setup() {
        // setup
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        // visit website
        driver.get("https://sma-fe.aa-qa.global-drum.com/");

        // Initializing Objects
        ds = new Discover(driver);
        sm = new SignupModal(driver);
    }

    public void quit() {
        driver.quit();
    }

    // Test Cases
    @Test(priority = 1)
    public void verify_google_auth_modal_on_clicking_cont_with_google_btn() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_signup_footer_btn();
        sm.click_continue_with_google_btn();
        quit();
    }

    @Test(priority = 2)
    public void verify_terms_and_condition_screen_after_completing_google_auth() throws InterruptedException {
        setup();
        ds.click_splash_next_btn();
        ds.set_dimensionss();
        ds.click_signup_footer_btn();

    }
}
