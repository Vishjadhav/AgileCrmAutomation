 package com.agilecrmpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.agileCrmAutomation.BaseClass;

public class CompanyPage extends BaseClass {

	By addCompanyButton = By.xpath("//button[contains(text(),'Add Company')]");
	By companyName = By.id("company_name");
	By continueEditingButton = By.id("continue-company");
	By companyUrl = By.id("company_url");
	By email = By.xpath("//div[@class='controls col-sm-9 second']//input[@id='email']");
	By mEmail = By.xpath("//div[@class='controls col-sm-9 second']//select[@name='email-select']");
    By update= By.xpath("//a[@id='company-update']");
	public void addCompany() {
		// action class
		waitForVisiibilityOfElement(driver.findElement(this.addCompanyButton));
		WebElement addCompanyButton = driver.findElement(this.addCompanyButton);
		Actions action = new Actions(driver);
		action.click(addCompanyButton).build().perform();
		waitForVisiibilityOfElement(driver.findElement(this.companyName));
		driver.findElement(this.companyName).sendKeys(" jabil1 ltd");
		WebElement continueEditingButton = driver.findElement(this.continueEditingButton);
		action.click(continueEditingButton).build().perform();

		WebElement companyUrl = driver.findElement(this.companyUrl);
		action.click(companyUrl).sendKeys("wwwwwwww").perform();

		waitForVisiibilityOfElement(driver.findElement(this.email));
		driver.findElement(this.email).sendKeys("sdf@gmail.com");
		Select select = new Select(driver.findElement(this.mEmail));
		select.selectByVisibleText("Alternate");
        click(this.update, "Update the company");
	}
}
