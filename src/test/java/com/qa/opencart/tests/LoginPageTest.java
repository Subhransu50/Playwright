package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	protected LoginPage loginPage;
	@Test(priority=1)
	public void loginPageNavigationTest()
	{
		loginPage=homePage.navigateToLoginPage();
		String ActualPageTitle=loginPage.getLoginPageTitle();
		System.out.println("Actual Page title is "+ActualPageTitle);
		Assert.assertEquals(ActualPageTitle, "Account Login");
	
	}
	@Test(priority=2)
	public void forgorPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Test(priority=3)
	public void appLoginTest()
	{
		
		boolean loginStatus=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(loginStatus,"Login failed");
	}

}
