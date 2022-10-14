package com.agileCrmAutomation;

import org.testng.annotations.Test;

import com.agilecrmpages.ContactPage;
import com.agilecrmpages.LoginPage;

public class ContactTest extends BaseClass {

@Test
public void contactTestMethod() throws InterruptedException
	
	{
		ContactTest contact = new ContactTest();
		launchBrowser("chrome");
		driver.navigate().to("boss123.agilecrm.com");
		LoginPage login1 = new LoginPage();
		login1.login("vishal1@yopmail.com", "Vishal@123");
		ContactPage object = new ContactPage();
		object.addContact();
		object.searchContact();
		object.updateContact();
		object.deleteContact();

	}

}
