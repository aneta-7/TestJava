package com.example.seleniumdemo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AnetaS\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void homePage() {
		driver.get("https://anetashop2.herokuapp.com/");
		element = driver.findElement(By.linkText("Log in"));
		assertNotNull(element);
	}

	@Test
	public void badLogin() {
		driver.get("https://anetashop2.herokuapp.com/");
		driver.findElement(By.linkText("Log in")).click();
		;

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("aneta@wp.pl");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");

		Timeout.seconds(3);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();

		assertEquals("Invalid email/password combination", actual);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("/test/resources/badLogin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void correctLogin() {
		driver.get("https://anetashop2.herokuapp.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("aneta.stypa7@wp.pl");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");

		Timeout.seconds(3);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		driver.findElement(By.linkText("Users")).click();

		Timeout.seconds(3);
		String actual = driver.findElement(By.xpath("//div[@class='container']/h1")).getText();

		assertEquals("All users", actual);

		driver.findElement(By.className("dropdown-toggle")).click();

		driver.findElement(By.xpath("//a[@href='/logout']")).click();

	}

	@Test
	public void someAds() {
		driver.get("https://anetashop2.herokuapp.com/");
		driver.findElement(By.linkText("Ads")).click();
		
		driver.findElement(By.xpath("//a[@href='/ads/2']")).click();
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("/test/resources/firstElement.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
