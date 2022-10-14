package com.agilecrmpages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.agileCrmAutomation.BaseClass;

public class ContactPage extends BaseClass {
	By contactmenubutton = By.id("contactsmenu");
    By AddContact=By.xpath("//div[@id='view-list']/div/button");
    By namefirst=By.id("fname");
    By Continueedit=By.xpath("//a[@href=\"#continue-contact\"]");
    By update=By.xpath("//a[@type='submit']");
    By Search=By.xpath("//li[@id='calendarmenu']/preceding::button[3]");
    By Allsearch=By.xpath("//a[text()='All']"); 
    By Checkboxcontact=By.xpath("//a[text()='Contacts']");
    By text=By.id("searchText");
    By serachbuttonclick=By.xpath("//i[@class='search material-icons']");
    By modellist=By.id("search-model-list");
    By contactdetails=By.xpath("//*[@id=\"contact-details-block\"]/div/div/div/div/div/div[1]/div/div/div[7]/a[1]");
    By namelast=By.name("lname");
    By update1=By.id("update");
    By Delete1=By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button");
    By Delete2=By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button");
    By finalDelete=By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button/following::li[10]/a");
    By Callback=By.id("success_callback");
    
	String firstName = "Thor";
	String lastName = "Odison";
	String emailId = "thor3312@gmail.com";
	String mobNumber = "5667775654";

	public void addContact() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// waitForVisibilityOfElement(driver.findElement(By.id("view-list")));
		click(this.contactmenubutton, "click on contactmenu");
		waitForVisiibilityOfElement(driver.findElement(this.AddContact));
		click(this.AddContact, "click on addcontact");
		waitForVisiibilityOfElement(driver.findElement(this.namefirst));
		driver.findElement(this.namefirst).sendKeys(firstName);
		click(this.Continueedit,"click on continue");
		click(this.update, "click on update");
	}

	public void searchContact() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(this.Search).click();
		click(this.Allsearch, "click on all checkbox");
		click(this.Checkboxcontact, "click on contact checkbox");
		driver.findElement(this.text).sendKeys(firstName);
		click(this.serachbuttonclick, "click on serch button");
		waitForVisiibilityOfElement(driver.findElement(this.modellist));
		driver.findElement(this.modellist).click();
	}

	public void updateContact() {

		driver.findElement(this.contactdetails).click();
		driver.findElement(this.namelast).sendKeys(" johnson123");
		driver.findElement(this.update1).click();
	}

	public void deleteContact() {
		waitForVisiibilityOfElement(driver.findElement(this.Delete1));
		driver.findElement(this.Delete2).click();
		click(this.finalDelete,"click on deelet");

		waitForVisiibilityOfElement(driver.findElement(this.Callback));
		driver.findElement(this.Callback).click();

	}

}