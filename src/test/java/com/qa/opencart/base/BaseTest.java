package com.qa.opencart.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlayWrightFactory;
import com.qa.opencart.pages.HomePage;

public class BaseTest {

	protected PlayWrightFactory pf;
	protected Page page;
	protected HomePage homePage;
	protected Properties prop;
	@BeforeTest
	public void setUp() throws Exception
	{
		pf=new PlayWrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		homePage=new HomePage(page);
				
	}
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}
}
