package com.agileCrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonApplianceSearch extends BaseClass {
	By DropdownBox=By.id("searchDropdownBox");
	By searchtext=By.id("twotabsearchtextbox");
	By submitclick=By.id("nav-search-submit-button");
	By productnames=By.xpath("//div[@class='sg-row']/descendant::h2/a/span");
	By productprice=By.xpath("//div[@class='sg-row']/descendant::span/span/span[@class='a-price-whole']");
	
	
	
	@BeforeMethod(groups="regression")
	@Parameters("browser")
	public void launch(String browser) {
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
	}

	@Test(groups="regression")
	public void test() {
		selectDropdownValByText(driver.findElement(this.DropdownBox), "Appliances");
		driver.findElement(this.searchtext).sendKeys("Washing Machine");
		click(this.submitclick, "Click on search button");
		List<WebElement> appliancesNames = driver.findElements(this.productnames);
		List<WebElement> appliancePrices = driver.findElements(this.productprice);

		for (int i = 0; i < appliancesNames.size(); i++) {
			String name = appliancesNames.get(i).getText();
			String price = appliancePrices.get(i).getText();
			System.out.println(name + ":" + price);
		}
	}

	@AfterMethod(groups="sanity")
	public void logout() {
		System.out.println("program executed successfully");
	}

}
