package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Wp extends WebDriverPage{

	public Wp(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://konto.interia.pl/logowanie?referer=http%3A%2F%2Fwww.interia.pl&crc=2124549700#iwa_source=pasek");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
