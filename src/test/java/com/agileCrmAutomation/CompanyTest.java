package com.agileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrmpages.CompanyPage;
import com.agilecrmpages.LoginPage;
import com.beust.jcommander.Parameter;

public class CompanyTest extends BaseClass {
	@BeforeTest()
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password ) {
		System.out.println("this is beforemethod annotation ");
		launchBrowser(browser);
		driver.navigate().to("https://boss123.agilecrm.com");
		LoginPage login = new LoginPage();
		login.login(username, password);
	}

	@Test()
	public void test() {
		System.out.println("this is test annotation ");
		CompanyPage companypage = new CompanyPage();
		companypage.addCompany();
	}



	@AfterTest()
	public void aftertest() {
		System.out.println("Done with program");
	}
}
