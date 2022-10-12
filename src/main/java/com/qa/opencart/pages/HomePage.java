package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	Page page;
	
	private String search="input[name='search']";
	private String searchIcon="button.btn.btn-default.btn-lg";
	private String searchPageHeader="div#content h1";
	private String loginLink="//a[text()='Login' and @class='list-group-item']";
			//"a:text('Login')";
	
	public HomePage(Page page)
	{
		this.page=page;
	}
	public String getHomePageTitle()
	{
		return page.title();
	}
	public String getHomePageUrl()
	{
		return page.url();
	}
	public String doSearch(String productName)
	{
		page.fill(search, productName);
		page.click(searchIcon);
		return page.textContent(searchPageHeader);
	}
	public LoginPage navigateToLoginPage()
	{
		page.click(loginLink);
		return new LoginPage(page);
	}
}
