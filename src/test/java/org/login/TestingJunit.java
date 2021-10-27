package org.login;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingJunit {

	static WebDriver driver;
	
	@BeforeClass
	public static void browserLaunh() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/");
		 String title = driver.getTitle();
		 boolean contains = title.contains("Facebook");
		 Assert.assertTrue(contains);
		 System.out.println("we are in Facebook page");
	}
	
	@Before
	public void timeBeforeCredentials() {
		
		//to find time
		Date d = new Date();
		System.out.println(d);
		
	}
	@Ignore
	@Test
	public void tc1() {
		WebElement txtUsername = driver.findElement(By.id("email"));
		boolean displayed = txtUsername.isDisplayed();
		//verification point
		Assert.assertTrue(displayed);
		System.out.println("username is displayed");
		WebElement txtUsername1 = driver.findElement(By.id("email"));		
		txtUsername1.sendKeys("ramsss");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		String attribute = txtPassword.getAttribute("id");
		Assert.assertEquals("pass", attribute);
		System.out.println("password field has the correct attribute");
		driver.findElement(By.id("pass")).sendKeys("12345");
		WebElement buttonLogin = driver.findElement(By.name("login"));
		boolean enabled = buttonLogin.isEnabled();
		Assert.assertEquals(true, enabled);
		System.out.println("login button is enabled");
		driver.findElement(By.name("login")).click();
		
	}
	
	@Test
	public void tc2() {
		
		System.out.println("we are in login page");
	}
	
	
	@After
	public void timeAfterCredentials() {
		
		Date d1 = new Date();
		System.out.println(d1);
	}
	
	@AfterClass
	public static void closeBrowser() {
		
		driver.close();
		System.out.println("test1");
		System.out.println("new feature");
		System.out.println("added on Branc A");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
