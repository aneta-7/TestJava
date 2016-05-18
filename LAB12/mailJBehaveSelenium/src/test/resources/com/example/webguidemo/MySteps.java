import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;

import com.example.webguidemo.Pages;

public class MySteps {

	private final Pages pages;

	public MySteps(Pages pages) {
		this.pages = pages;
	}

	@Then("user is logOnet")
	public void thenUserIsLogOnet() {
		// TODO
	}

	@Given("a wp login page")
	public void givenAWpLoginPage() {
		pages.wp().open();
	}

	@Then("user is logWp")
	public void thenUserIsLogWp() {
		String title = pages.wp().getTitle();
		assertEquals("Poczta - Wirtualna Polska", title);
	}

	@When("send nameWp")
	public void whenSendNameWp() {
		pages.wp().findElement(By.className("login_username")).clear();
		pages.wp().findElement(By.className("login_username")).sendKeys("testowanie2016wp.pl");

	}

	@When("click loginWp")
	public void whenClickLoginWp(){
		 pages.wp().findElement(By.id("btnSubmit")).click();
		 }

	@When("send passwordOnet")
	public void whenSendPasswordOnet() {
		// TODO
	}

	@When("send passwordWp")
	public void whenSendPasswordWp() {
		pages.wp().findElement(By.className("login_password")).clear();
		pages.wp().findElement(By.className("login_password")).sendKeys("Testowanie");
	}

	@Given("a onet login page")
	public void givenAOnetLoginPage() {
		// TODO
	}

	@When("click loginOnet")
	public void whenClickLoginOnet() {
		// TODO
	}

	@When("send nameOnet")
	public void whenSendNameOnet() {
		// TODO
	}
}