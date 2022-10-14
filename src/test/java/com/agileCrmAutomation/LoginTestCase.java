package com.agileCrmAutomation;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrmpages.LoginPage;

public class LoginTestCase extends BaseClass{
	By condition1=By.xpath("//a[@class='close']");
	
	@Test(groups ={"sanity"})
	@Parameters({ "browser", "username", "password" })
	public void a_login(String browser, String username, String password) {
		LoginTestCase Login = new LoginTestCase();
		Login.launchBrowser(browser);
		driver.navigate().to("https://boss123.agilecrm.com");
		LoginPage loginuser = new LoginPage();
		System.out.println(" Testcase1- username and valid password");
		loginuser.login(username, password);
		Login.condition();
		System.out.println("Testcase2-invalid username and valid password");
		loginuser.login("cst47@yopmail.com", "Vishal@123");
		Login.condition();
		System.out.println("Testcase3-invalid username and valid password");
		loginuser.login("cst1@yopmail.org", "Vishal@123");
		Login.condition();
		System.out.println("Testcase4-invalid username with spaces and valid password");
		loginuser.login("  cst1@yopmail.com", "Vishal@123");
		Login.condition();
		loginuser.forgotpassword();
	}

	public void condition() {
		if (driver.findElement(this.condition1).isDisplayed())// error massage found clear data and
																				// enter new test case data
		{
			System.out.println("Invalid Creditial");

		} else {
			System.out.println("Login sucessfully");
			LoginPage logout = new LoginPage();// after login logout
			logout.logout();
		}
	}
}
