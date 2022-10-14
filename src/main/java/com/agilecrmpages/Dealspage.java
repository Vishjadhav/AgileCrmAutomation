package com.agilecrmpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.agileCrmAutomation.BaseClass;

public class Dealspage extends BaseClass {
	
    By dealmenubutton=By.id("dealsmenu");
    By ClickonDeal=By.xpath("//button[contains(text(),'Add Deal')]");
    By Dealname=By.xpath("//form[@id='opportunityForm']/descendant::input[@id='name']");
    By currency=By.xpath("//*[@id=\"opportunityForm\"]/descendant::input[@name='currency_conversion_value']");
    By savebutton=By.xpath("//div[@id='deals-new-footer']/a");
    By calendarmenu=By.xpath("//li[@id='calendarmenu']/preceding::button[3]");
    By allbutton=By.xpath("//a[text()='All']");
    By clickondeal=By.xpath("//a[text()='Deals']");
    By searchtext=By.id("searchText");
    By searchresult=By.xpath("//button[@id=\"search-results\"]"); 
    By serachmodellist=By.xpath("//*[@id='deal-search-model-list']/tr[1]");
    By dropdownaction=By.xpath("//div[@id='deal-detail-actions-dropdown']/descendant::a[7]");
    By updatemodel=By.xpath("//*[@id='opportunityUpdateModal']/div[2]/div/div[2]");
    By pipelineMilestone=By.id("pipeline_milestone");
    By archive=By.xpath("//a[@id='opportunity_archive']");
    
    
    
	public void Adddeals() {
		click(this.dealmenubutton, "Clicked on deals menu");
		click(this.ClickonDeal, "click on add DEAL");
		waitForVisiibilityOfElement(driver.findElement(this.Dealname));
		driver.findElement(this.Dealname).sendKeys("dealSales1");
		driver.findElement(this.currency).sendKeys("15000");
		waitForVisiibilityOfElement(driver.findElement(this.savebutton));
		click(this.savebutton, "click on save");
		driver.findElement(this.calendarmenu).click();
		click(this.allbutton, "click on all");
		click(this.ClickonDeal, "click on deals");
		driver.findElement(this.searchtext).click();
		WebElement search = driver.findElement(this.searchtext);
		search.sendKeys("SynovaSales");
		driver.findElement(this.searchresult).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(this.serachmodellist).click();
		driver.findElement(this.dropdownaction).click();
		waitForVisiibilityOfElement(
	    driver.findElement(this.updatemodel));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select select = new Select(driver.findElement(this.pipelineMilestone));
		select.selectByVisibleText("Won");
		driver.findElement(this.archive).click();
	}
}

