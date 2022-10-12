package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.microsoft.playwright.Page;
import com.qa.opencart.base.BaseTest;
/*import com.qa.opencart.factory.PlayWrightFactory;
import com.qa.opencart.pages.HomePage;*/

public class HomePageTest extends BaseTest{

	/*PlayWrightFactory pf;
	Page page;
	HomePage homePage;
	@BeforeTest
	public void setUp()
	{
		pf=new PlayWrightFactory();
		page=pf.initBrowser("chrome");
		homePage=new HomePage(page);
				
	}*/
	@Test
	public void homePageTitleTest()
	{
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Account Logout","Assertion failed");
	}
	@Test
	public void homePageUrlTest()
	{
		String actualUrl=homePage.getHomePageUrl();
		Assert.assertEquals(actualUrl, "https://naveenautomationlabs.com/opencart/index.php?route=account/logout","Assertion failed");
	}
	@DataProvider(name="productName")
	public Object[][] getProductName()
	{
		Object[][] productName=new Object[][]
								{
			{"Macbook"},
			{"iMac"},
			{"iPhone"}
								};
		
		return productName;
	}
	
	@Test(dataProvider="productName")
	public void searchTest(String productNameIs)
	{
		String actualSearchHeader=homePage.doSearch(productNameIs);
		Assert.assertEquals(actualSearchHeader, "Search - "+productNameIs,"Assertion Failed");
	}
	/*@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}*/
}
