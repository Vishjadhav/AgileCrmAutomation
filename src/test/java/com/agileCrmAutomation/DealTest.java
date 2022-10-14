package com.agileCrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrmpages.DealPage;
import com.agilecrmpages.LoginPage;

public class DealTest extends BaseClass {
	By Dealmenu=By.id("dealsmenu");

	@BeforeMethod(groups={"regression","sanity"})
	@Parameters({"browser","username","password"})
	public void before(String browser,String username,String password) {
		launchBrowser(browser);
		driver.navigate().to("https://boss123.agilecrm.com/");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username,password );
	}

	@Test(groups={"regression","sanity"})
	public void test() throws Exception {
		click(this.Dealmenu, "Click on Deals Menu");
		DealPage dealsPage = new DealPage();
		dealsPage.changeDealsStatus("New", "Prospect");
	}

}
