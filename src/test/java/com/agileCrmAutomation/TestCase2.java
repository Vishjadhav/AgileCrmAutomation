package com.agileCrmAutomation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCase2 extends BaseClass {
	@BeforeTest
	public void beforetest() {
		System.out.println("This is beforetest method");
		launchBrowser("chrome");
		driver.get("https://www.google.com");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is before method");
	}
	@Test
	public void test1() {
		System.out.println("this is test1");
		Assert.fail("testc case fail");
	}
	@Test
	public void test2() {
		System.out.println("this is test2");
		System.out.println(driver.getTitle());
		Assert.fail("testc case fail");
		
	}
	@Test(dependsOnMethods="test2")
	public void test3() {
		System.out.println("this is test3");
	}
}
