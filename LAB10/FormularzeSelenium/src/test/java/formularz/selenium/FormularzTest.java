package formularz.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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
	public void poprawnyFormularz() {		
		Formularz formularz = new Formularz(driver);
		formularz.zaznaczOczy();
		formularz.zaznaczKolory();
		
		formularz.przeslijFormularz();

		String actual = formularz.poprawnie();

		assertEquals("Twoja odpowiedü zosta≥a zapisana.", actual);

	}

	@Test
	public void brakOczu() {
		Formularz formularz = new Formularz(driver);
		formularz.zaznaczKolory();

		formularz.przeslijFormularz();

		String actual = formularz.bladOczy();

		assertEquals("Odpowiedü na to pytanie jest wymagana", actual);
	}
	
	@Test
	public void brakKorol() {
		Formularz formularz = new Formularz(driver);
		formularz.zaznaczOczy();

		formularz.przeslijFormularz();

		String actual = formularz.bladKolor();

		assertEquals("Odpowiedü na to pytanie jest wymagana", actual);
	}

	@Test
	public void zaDuzoKoloru(){
		Formularz formularz = new Formularz(driver);
		formularz.zaDuzoKolorow();

		formularz.przeslijFormularz();

		String actual = formularz.bladZaDuzo();

		assertEquals("maksymalnie 3", actual);
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
