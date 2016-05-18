package projekt.page;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class MyHeroku extends WebDriverPage {

		public MyHeroku(WebDriverProvider driverProvider) {
			super(driverProvider);
		}

		public void open() {
			get("https://anetashop2.herokuapp.com");
			manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
}
