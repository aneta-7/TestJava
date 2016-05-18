package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Onet extends WebDriverPage {

	public Onet(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://konto.onet.pl/auth.html?app_id=poczta.onet.pl.front.onetapi.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
