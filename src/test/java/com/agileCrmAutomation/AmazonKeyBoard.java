package com.agileCrmAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonKeyBoard extends BaseClass {
	By Desktopbutton = By.id("desktop-banner");
	By Delacontainerproductnames = By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']");
	By pricetagcontainer = By
			.xpath("//div[@class='BadgeAutomated-module__badgeOneLineContainer_yYupgq1lKxb5h3bfDqA-B']/div[1]");

	@BeforeMethod(groups = { "sanity" })
	@Parameters({ "browser", "username", "password" })
	public void beforeMethod(String browser, String username, String password) {
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
	}

	@Test(groups = { "sanity" })
	public void test() throws AWTException {
		WebElement image = driver.findElement(this.Desktopbutton);
		Actions action = new Actions(driver);
		action.contextClick(image).build().perform();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent window id" + parentWindowId);
		Set<String> allwindowsIds = driver.getWindowHandles();
		for (String windowId : allwindowsIds) {
			if (!windowId.equals(parentWindowId)) {
				System.out.println("child window Id" + windowId);
				driver.switchTo().window(windowId);
				System.out.println(driver.getTitle());
				List<WebElement> productName = driver.findElements(this.Delacontainerproductnames);
				List<WebElement> pricetag = driver.findElements(this.pricetagcontainer);

				for (int i = 0; i <= productName.size(); i++) {
					String pname = productName.get(i).getText();
					String ptag = pricetag.get(i).getText();

					System.out.println(pname + ":" + ptag);
				}

			}
		}
	}

	@AfterMethod(groups = "sanity")
	public void after() {
		System.out.println("Runs exactly");
	}
}
