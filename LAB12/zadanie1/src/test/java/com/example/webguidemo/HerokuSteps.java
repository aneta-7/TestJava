package com.example.webguidemo;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;

import com.example.webguidemo.Pages;

public class HerokuSteps {

	private final Pages pages;

	public HerokuSteps(Pages pages) {
		this.pages = pages;
	}

	@Then("user not login")
	public void thenUserNotLogin() {
		String bad = pages.badLogin().findElement(By.xpath("/html/body/div/div[1]")).getText();
		assertEquals("Invalid email/password combination", bad);
	}

	@When("user click badButton")
	public void whenUserClickBadButton() {
		pages.badLogin().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
	}

	@When("user send login")
	public void whenUserSendLogin() {
		pages.login().findElement(By.id("session_email")).sendKeys("aneta.stypa7@wp.pl");
	}

	@Given("user on Login badPage")
	public void givenUserOnLoginBadPage() {
		pages.badLogin().open();
	}

	@Then("user login")
	public void thenUserLogin() {
		String login = pages.login().getTitle();
		assertEquals("Aneta | Ads app", login);
	}

	@When("user send password")
	public void whenUserSendPassword() {
		pages.login().findElement(By.id("session_password")).sendKeys("123456");
	}

	@When("user send badPassword")
	public void whenUserSendBadPassword() {
		pages.badLogin().findElement(By.id("session_password")).sendKeys("bad");
	}

	@Given("user on Login page")
	public void givenUserOnLoginPage() {
		pages.login().open();
	}

	@When("user click button")
	public void whenUserClickButton() {
		pages.login().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
	}

	@When("user send badLogin")
	public void whenUserSendBadLogin() {
		pages.badLogin().findElement(By.id("session_email")).sendKeys("bad@bad.pl");
	}
}