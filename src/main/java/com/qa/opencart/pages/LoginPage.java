package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	private String emailId="//input[@id='input-email']";
	private String password="//input[@id='input-password']";
	private String loginBtn="//input[@value='Login']";
	private String forgotPwdLink="//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink="//a[normalize-space()='Logout' and @class='list-group-item']";
	
	public LoginPage(Page page)
	{
		this.page=page;
	}
	public String getLoginPageTitle()
	{
		String title=page.title();
		return title;
	}
	public boolean isForgotPwdLinkExist()
	{
		Boolean isVisile=page.isVisible(forgotPwdLink);
		return isVisile;
	}
	
	public boolean doLogin(String appUserName,String appPassword)
	{
		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if(page.isVisible((logoutLink)))
				{
			System.out.println("User is loggedIn successfully...");
			return true;
				}
		return false;
	}
	
	
}
