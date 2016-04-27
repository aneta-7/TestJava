package com.example.seleniumdemo;


import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplisitTest {

@Test
public void explisit(){
		WebDriver driver=new FirefoxDriver();
        driver.get("https://anetashop2.herokuapp.com/");
	    WebDriverWait wait=new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));

	    assertEquals("Home | Ads app", driver.getTitle());
	    driver.quit();
}
}
