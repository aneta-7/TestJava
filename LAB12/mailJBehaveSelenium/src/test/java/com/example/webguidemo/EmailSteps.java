package com.example.webguidemo;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;

import com.example.webguidemo.Pages;

public class EmailSteps {

	private final Pages pages;

	public EmailSteps(Pages pages) {
		this.pages = pages;
	}

	@Then("user is logOnet")
	public void thenUserIsLogOnet() {
		String actual = pages.onet().getTitle();
		assertEquals("Poczta w Onet.pl", actual);
	}

	@Given("a wp login page")
	public void givenAWpLoginPage() {
		pages.wp().open();
	}

	@Then("user is logWp")
	public void thenUserIsLogWp() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String title = pages.wp().getTitle();
		assertEquals("Interia - Polska i œwiat: informacje, sport, gwiazdy.", title);
	}

	@When("send nameWp")
	public void whenSendNameWp() {
		pages.wp().findElement(By.id("iLogin")).clear();
		pages.wp().findElement(By.id("iLogin")).sendKeys("testowanie2016@interia.pl");

	}

	@When("click loginWp")
	public void whenClickLoginWp() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pages.wp().findElement(By.xpath("id('loginAccountForm')/div/button")).click();
	}

	@When("send passwordOnet")
	public void whenSendPasswordOnet() {
		pages.onet().findElement(By.id("f_password")).sendKeys("*******");
	}

	@When("send passwordWp")
	public void whenSendPasswordWp() {
		pages.wp().findElement(By.id("iPassword")).clear();
		pages.wp().findElement(By.id("iPassword")).sendKeys("******");
	}

	@Given("a onet login page")
	public void givenAOnetLoginPage() {
		pages.onet().open();
	}

	@When("click loginOnet")
	public void whenClickLoginOnet() {
		pages.onet().findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();
	}

	@When("send nameOnet")
	public void whenSendNameOnet() {
		pages.onet().findElement(By.id("f_login")).sendKeys("testowanie2016@onet.pl");
	}


	
	@Given("a login user in onet")
	public void givenALoginUserInOnet() {
		pages.onet().open();
		pages.onet().findElement(By.id("f_login")).clear();
		pages.onet().findElement(By.id("f_login")).sendKeys("testowanie2016@onet.pl");
		pages.onet().findElement(By.id("f_password")).clear();
		pages.onet().findElement(By.id("f_password")).sendKeys("*******");
		pages.onet().findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();
	}

	@Then("userInteria get a message")
	public void thenUserInteriaGetAMessage() {
		pages.wp().open();
		pages.wp().findElement(By.id("iLogin")).sendKeys("testowanie2016@interia.pl");
		pages.wp().findElement(By.id("iPassword")).sendKeys("*******");
		pages.wp().findElement(By.xpath("id('loginAccountForm')/div/button")).click();

		pages.wp().findElement(By.xpath("id('header')/div[2]/div/div/div/a[1]/span[1]")).click();
		pages.wp().findElement(By.xpath("id('header_login')/ul/li[2]/a")).click();

		pages.wp().findElement(By.xpath("id('ng-app')/body/section[5]/section[1]/div/section/ul/li[2]/a")).click();
		String title = pages.wp()
				.findElement(
						By.xpath("id('ng-app')/body/section[4]/div[2]/div[1]/section/ul/li[1]/div[2]/div[1]/div/span"))
				.getText();

		assertEquals("testowy email", title);
	}

	@When("click wyslij")
	public void whenClickWyslij() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pages.onet().findElement(By.id("newmail-actions-top-send")).click();
	}

	@When("send odbiorca")
	public void whenSendOdbiorca() {
		pages.onet().findElement(By.id("newmail-txtmailto-multipleInput")).clear();
		pages.onet().findElement(By.id("newmail-txtmailto-multipleInput")).sendKeys("testowanie2016@interia.pl");
	}

	@When("send tytul")
	public void whenSendTytul() {
		pages.onet().findElement(By.id("newmail-subject")).clear();
		pages.onet().findElement(By.id("newmail-subject")).sendKeys("testowy email");
	}

	@When("click NowyList")
	public void whenClickNowyList() {
		pages.onet().findElement(By.xpath("id('NewMail-button')/span")).click();
	}

	@When("send tresc")
	public void whenSendTresc() {
		pages.onet().findElement(By.id("newmail-subject")).clear();
		pages.onet().findElement(By.id("newmail-subject")).sendKeys("testowy email");
	}

	@When("click WyslijNowa")
	public void whenClickWyslijNowa() {
		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[3]/button[1]")).click();

		String messange = pages.wp().findElement(By.xpath("id('ng-app')/body/div[2]/div/ul/li/div")).getText();
		assertEquals("Wiadomoœæ wys³ana", messange);

	}

	@Then("userOnet get a message")
	public void thenUserOnetGetAMessage() {
		pages.onet().open();
		pages.onet().findElement(By.id("f_login")).clear();
		pages.onet().findElement(By.id("f_login")).sendKeys("testowanie2016@onet.pl");
		pages.onet().findElement(By.id("f_password")).clear();
		pages.onet().findElement(By.id("f_password")).sendKeys("**********");
		pages.onet().findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();

		pages.onet().findElement(By.xpath("id('liFolder_349804')/a")).click();
		String title = pages.onet().findElement(By.xpath("//ul/li[4]/div/div/div")).getText();

		assertEquals("testowa wiadomosc ", title);
	}

	@When("go to email account")
	public void whenGoToEmailAccount() {
		pages.wp().findElement(By.xpath("id('header')/div[2]/div/div/div/a[1]/span[1]")).click();
		pages.wp().findElement(By.xpath("id('header_login')/ul/li[2]/a")).click();
	}

	@Given("a login user in interia")
	public void givenALoginUserInInteria() {
		pages.wp().open();
		pages.wp().findElement(By.id("iLogin")).sendKeys("testowanie2016@interia.pl");
		pages.wp().findElement(By.id("iPassword")).sendKeys("**********");
		pages.wp().findElement(By.xpath("id('loginAccountForm')/div/button")).click();
	}

	@When("click nowaWiadomosc")
	public void whenClickNowaWiadomosc() {
		pages.wp().findElement(By.xpath("id('ng-app')/body/section[5]/section[1]/div/section/ul/li[1]/a")).click();

		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[4]/div[3]/div/textarea"))
				.clear();
		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[4]/div[3]/div/textarea"))
				.sendKeys("testowanie2016@onet.pl");

		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[5]/input")).clear();
		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[5]/input"))
				.sendKeys("testowa wiadomosc");

	}

	@Given("a login userOnet")
	public void givenALoginUserOnet() {
		pages.onet().open();
		pages.onet().findElement(By.id("f_login")).clear();
		pages.onet().findElement(By.id("f_login")).sendKeys("testowanie2016@onet.pl");
		pages.onet().findElement(By.id("f_password")).clear();
		pages.onet().findElement(By.id("f_password")).sendKeys("********");
		pages.onet().findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();
	}

	@When("go to SPAM")
	public void whenGoToSPAM() {
		pages.onet().findElement(By.xpath("id('liFolder_349804')/a")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pages.onet().findElement(By.xpath("id('liFolder_349804')/a/span")).click();
		pages.onet().findElement(By.xpath("id('popupConfirmButtonSave')/span")).click();

	}

	@Then("SPAM is empty")
	public void thenSPAMIsEmpty() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String empty = pages.onet().findElement(By.xpath("id('mailList-list-items')/div[4]")).getText();

		assertEquals("Ten folder jest pusty", empty);
	}

	
	
	@When("send a email to onet")
	public void whenSendAEmailToOnet(){
		pages.wp().findElement(By.xpath("id('ng-app')/body/section[5]/section[1]/div/section/ul/li[1]/a")).click();

		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[4]/div[3]/div/textarea"))
				.clear();
		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[4]/div[3]/div/textarea"))
				.sendKeys("testowanie2016@onet.pl");

		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[5]/input")).clear();
		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[5]/input"))
				.sendKeys("testowa wiadomosc");
		pages.wp().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[3]/button[1]")).click();

	}
	@Given("a login interiaUser")
	public void givenALoginInteriaUser(){
		pages.wp().open();
		pages.wp().findElement(By.id("iLogin")).sendKeys("testowanie2016@interia.pl");
		pages.wp().findElement(By.id("iPassword")).sendKeys("*******");
		pages.wp().findElement(By.xpath("id('loginAccountForm')/div/button")).click();
		
		pages.wp().findElement(By.xpath("id('header')/div[2]/div/div/div/a[1]/span[1]")).click();
		pages.wp().findElement(By.xpath("id('header_login')/ul/li[2]/a")).click();
		
	}
	@Then("answer interia")
	public void thenAnswerInteria(){
		pages.wp().open();
		pages.wp().findElement(By.id("iLogin")).sendKeys("testowanie2016@interia.pl");
		pages.wp().findElement(By.id("iPassword")).sendKeys("*********");
		pages.wp().findElement(By.xpath("id('loginAccountForm')/div/button")).click();
		
		pages.wp().findElement(By.xpath("id('header')/div[2]/div/div/div/a[1]/span[1]")).click();
		pages.wp().findElement(By.xpath("id('header_login')/ul/li[2]/a")).click();
		
		 pages.wp().findElement(By.xpath("id('ng-app')/body/section[5]/section[1]/div/section/ul/li[2]/a")).click();

		 
	}
	@When("onetUser get a emial")
	public void whenOnetUserGetAEmial(){
		pages.onet().open();
		pages.onet().findElement(By.id("f_login")).clear();
		pages.onet().findElement(By.id("f_login")).sendKeys("testowanie2016@onet.pl");
		pages.onet().findElement(By.id("f_password")).clear();
		pages.onet().findElement(By.id("f_password")).sendKeys("*********");
		pages.onet().findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		pages.onet().findElement(By.xpath("id('liFolder_349804')/a")).click();
		pages.onet().findElement(By.xpath("//ul/li[4]/div/div/div")).click();
		pages.onet().findElement(By.id("readmail-actions-top-reply")).click();
		pages.onet().findElement(By.id("newmail-actions-top-send")).click();

	}
	
	
}