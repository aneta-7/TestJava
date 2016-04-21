package com.example.seleniumdemo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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
		
	//	driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void homePage() {
		driver.get("http://www.allegro.pl");
		element = driver.findElement(By.linkText("Strefa Marek"));
		assertNotNull(element);
	}

	@Test
	public void searchTelewizor() {
		driver.get("http://www.allegro.pl/");
		driver.findElement(By.linkText("Strefa Marek")).click();
		element = driver.findElement(By.name("string"));

		element.sendKeys("Telewizor");

		driver.findElement(By.xpath("//form[@class='main-search']/input[@class='sprite search-btn']")).click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("/test/resources/telewizory.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void noSearchProduct() {
		driver.get("http://www.allegro.pl");
		element = driver.findElement(By.name("string"));
		element.sendKeys("@324342342343");
		assertNotNull(element);

		driver.findElement(By.xpath("//form[@class='main-search']/input[@class='sprite search-btn']")).click();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/brakProduktu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void Product(){
		driver.get("http://www.allegro.pl/");

		element = driver.findElement(By.name("string"));

		
		element.sendKeys("Czekolada");

		driver.findElement(By.xpath("//form[@class='main-search']/input[@class='sprite search-btn']")).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("/test/resources/czelolada.png"));
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
