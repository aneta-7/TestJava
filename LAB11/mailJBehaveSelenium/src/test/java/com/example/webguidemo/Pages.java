package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Onet;
import com.example.webguidemo.pages.Wp;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Onet onet;
	private Wp wp;

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Onet onet() {
		if (onet == null) {
			onet = new Onet(driverProvider);
		}
		return onet;
	}
	
	public Wp wp(){
		if (wp == null) {
			wp = new Wp(driverProvider);
		}
		return wp;
	}
}