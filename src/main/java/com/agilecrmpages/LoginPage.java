package com.agilecrmpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agileCrmAutomation.BaseClass;

public class LoginPage extends BaseClass {
	By uname=(By.name("email"));
	By password=(By.name("password"));
	By signIn=(By.xpath("//input[@type='submit']"));
	By img=(By.xpath("//img[@class='pos-rlt pos-t-xs']"));
	By signout=(By.xpath("//a[contains(@class,'logout-in-modal')]"));
	By forgotButton=By.xpath("//*[@id=\"agile\"]/div[2]/div[2]/small[2]/a[1]");
	By mail1=By.xpath("//div[@class='list-group-item']/input");
	By Listofgroup=By.xpath("//div[@class='list-group-item']/input");
	By submit=By.xpath("//*[@id=\"forgot_password\"]/input");
	By condition=By.xpath("//a[@class='close']");
	
	public void login(String username, String password) {
		WebElement uname = driver.findElement(this.uname);
		fluentWait(this.uname);
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(this.password);
		pwd.sendKeys(password);
		WebElement signIn = driver.findElement(this.signIn);
		signIn.click();
	}

	public void logout() {
		WebElement img = driver.findElement(this.img);
		img.click();
		WebElement signout = driver.findElement(this.signout);
		signout.click();
	}

	public void forgotpassword() {
		click(this.forgotButton, "click to forgot password button");
		click(this.mail1, "enter mail id");
		driver.findElement(this.Listofgroup).sendKeys("cst27@yopmail.com");
		click(this.submit, "click to submit");
		System.out.println("We have sent you an email");
	}
	public void condition() {
		if (driver.findElement(this.condition).isDisplayed())// error massage found clear data and
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