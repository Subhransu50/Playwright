package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFactory {
	Playwright playWright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	//public Page initBrowser(String browserName) 
	public Page initBrowser(Properties pr){
		String browserName=pr.getProperty("browser").trim();
		System.out.println("Browser name is : "+browserName);
		playWright=Playwright.create();
		
		switch (browserName) {
		case "chromium":
			browser=playWright.chromium()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(false));
			
			break;
		case "chrome":
			browser=playWright.chromium()
					.launch(new BrowserType.LaunchOptions()
							.setChannel("chrome")
							.setHeadless(false));
			
			break;
		case "firefox":
			browser=playWright.firefox()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(false));
			
			break;
		case "safari":
			browser=playWright.webkit()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(false));
			
			break;	

		default:
			break;
		}
		browserContext=browser.newContext();
		page=browserContext.newPage();
		//page.navigate("https://naveenautomationlabs.com/opencart/");
		page.navigate(pr.getProperty("url").trim());
		return page;
	}
	/**
	 * @throws IOException 
	 * 
	 */
	public Properties init_prop() throws IOException
	{
		File f=new File("./src/test/resources/config/config.properties");
		FileInputStream ip=new FileInputStream(f);
		Properties pr=new Properties();
		pr.load(ip);
		return pr;
	}
}
