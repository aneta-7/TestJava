package projekt.tests;

import org.jbehave.web.selenium.WebDriverProvider;

import projekt.page.MyHeroku;

public class Pages {

	private WebDriverProvider driverProvider;
	
	private MyHeroku heroku;
	
	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}
	
	public MyHeroku heroku() {
		if (heroku == null) {
			heroku = new MyHeroku(driverProvider);
		}
		return heroku;
	}
}
