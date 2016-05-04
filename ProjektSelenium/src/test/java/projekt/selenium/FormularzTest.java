package projekt.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FormularzTest {

	private static WebDriver driver;
	WebElement element;

	// link do formularza http://goo.gl/forms/ji37XaAL1s

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AnetaS\\Downloads\\chromedriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Logowanie() {
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.Wyloguj();
	}

	@Test
	public void ZobaczU¿ytkowników() {
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.Uzytkownicy();

		String actual = driver.getTitle();

		assertEquals("All users | Ads app", actual);
		formularz.Wyloguj();
	}

	@Test
	public void NowyProdukt() {
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.DodajProdukt();

		String actual = driver.findElement(By.xpath("/html/body/div/div")).getText();

		assertEquals("Ad was successfully created.", actual);

		formularz.Wyloguj();

	}
	
	@Test
	public void EdytujProdukt(){
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.EdytujOgloszenie();
		
		String actual = driver.findElement(By.xpath("/html/body/div/div")).getText();
		
		assertEquals("Ad was successfully updated.", actual);
		
		formularz.Wyloguj();
	}
	
	

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
