package com.agileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrmpages.CompanyPage;
import com.agilecrmpages.LoginPage;

public class DealsDrag extends BaseClass {
	By delasmenu = By.id("dealsmenu");
	By pagingmodellist = By.xpath("//ul[id@='deals-by-paging-model-list]'/descendant::div[@data='New'][1]");
	By dstelementpath = By.id("deals-by-paging-model-list");

	@BeforeMethod(groups = { "regression", "sanity" })
	@Parameters({ "browser", "username", "password" })
	public void before(String browser, String username, String password) {
		launchBrowser(browser);
		driver.navigate().to("https://boss123.agilecrm.com/");
		LoginPage login = new LoginPage();
		login.login(username, password);
	}

	@Test(groups = { "regression", "sanity" })
	public void test() {
		click(this.delasmenu, "Clicked on deals menu");
		WebElement sourceElement = driver.findElement(this.pagingmodellist);
		WebElement dstElement = driver.findElement(this.dstelementpath);
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, dstElement).build().perform();
	}

	@AfterMethod(groups = "sanity")
	public void after() {
		System.out.println("this is aftermethod");
	}

}
