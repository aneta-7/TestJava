package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Login;
import com.example.webguidemo.pages.BadLogin;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;

	// Pages
	private Home home;
	private Login login;
	private BadLogin badLogin;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}

	public Login login() {
		if (login == null) {
			login = new Login(driverProvider);
		}
		return login;
	}

	public BadLogin badLogin() {
		if (badLogin == null) {
			badLogin = new BadLogin(driverProvider);
		}
		return badLogin;
	}
}