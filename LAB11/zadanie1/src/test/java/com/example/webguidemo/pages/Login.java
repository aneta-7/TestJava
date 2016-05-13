package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Login extends WebDriverPage {

	public Login(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://anetashop2.herokuapp.com/login");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
