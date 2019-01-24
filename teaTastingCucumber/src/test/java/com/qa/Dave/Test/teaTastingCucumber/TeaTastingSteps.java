package com.qa.Dave.Test.teaTastingCucumber;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Checkout;
import pages.Home;
import pages.Menu;
import utility.Constant;

public class TeaTastingSteps {

	WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	
	@Before
	public void setup() {
	System.setProperty("webdriver.chrome.driver", Constant.driverLocation);
	driver = new ChromeDriver();
	report = new ExtentReports(Constant.folderPath + Constant.reportFile);
	test = report.startTest("TeaTastingSiteLogin");
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address(){
		
		driver.get(Constant.siteLocation);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Website loaded correctly");
	    
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page(){
		Home page = PageFactory.initElements(driver, Home.class);
		page.goWelcomePage(driver);
		test.log(LogStatus.INFO, "Navigated to the menu page");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products(){
		Menu page1 = PageFactory.initElements(driver, Menu.class);
		
		try {
		assertEquals("Green Tea", page1.checkTheMenu(driver));
		test.log(LogStatus.PASS, "List successfully displayed");
		} catch (Exception E) {
			test.log(LogStatus.FAIL, "List not displayed");
		}
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button(){
		Menu page2 = PageFactory.initElements(driver, Menu.class);
		page2.clickTheCheckout(driver);
		test.log(LogStatus.INFO, "checkout button works");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page(){
		Checkout page3 = PageFactory.initElements(driver, Checkout.class);
		try {
		assertEquals("Enter your billing information", page3.checkThatCheck(driver));
		test.log(LogStatus.PASS, "You have landed on the checkout page");
		} catch (Exception E) {
			test.log(LogStatus.FAIL, "Uanable to take you to the checkout page");
		}
	}
	
	@After
	public void teardown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
	
}
