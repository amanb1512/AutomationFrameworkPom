package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		tasksPage = new TasksPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		
		
	}
	
	
	@Test(priority = 1)
	public void contactPageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	
	
	}
	
	@Test(priority = 2)
	public void userNameLabelTest() {
		testUtil.switchToFrame();
		boolean flag= homePage.verifyUserNameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		 contactsPage =homePage.clickOnContactsLink();
	}
	
	@Test(enabled = false)
	public void verifyDealsPageTest() {
		testUtil.switchToFrame();
	 dealsPage = homePage.clickOnDealsLink();
		
	}
	
	@Test(enabled = false)
	public void verifyTasksPageTest() {
		tasksPage = homePage.clickOnTasksLink();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
