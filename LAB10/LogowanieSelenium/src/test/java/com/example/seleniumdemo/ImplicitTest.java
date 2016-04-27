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
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void homePage() {
		driver.get("https://anetashop2.herokuapp.com/");
		element = driver.findElement(By.linkText("Log in"));
		assertNotNull(element);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
