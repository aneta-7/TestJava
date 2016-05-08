package projekt.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularzTest {

	private static WebDriver driver;
	WebElement element;


	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AnetaS\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	//	driver = new FirefoxDriver();
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

		String actual = driver.findElement(By.xpath("/html/body/div/h1")).getText();

		assertEquals("All users", actual);
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
	
	@Test
	public void UsuwanieOgloszenia(){
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.UsunOgloszenie();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		String actual = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
		assertEquals("Ad was successfully destroyed.", actual);
		
		formularz.Wyloguj();
	}
	
	@Test
	public void BledneLogowanie(){
		Formularz formularz = new Formularz(driver);
		formularz.BlednieZaloguj();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(formularz.actualBadLogin));
		
		String actual = formularz.actualBadLogin.getText();
		
		assertEquals("Invalid email/password combination", actual);

	}
	
	@Test
	public void BledneDodawanie(){
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.BlednieDodajProdukt();
		
		String actual = driver.findElement(By.xpath("id('error_explanation')/h2")).getText();
		
		assertEquals("10 errors prohibited this ad from being saved:", actual);
		
		formularz.Wyloguj();
	}
	
	@Test
	public void BledneEdytowanie(){
		Formularz formularz = new Formularz(driver);
		formularz.Zaloguj();
		formularz.BlednieEdytujOgloszenie();
		
		String actual = driver.findElement(By.xpath("id('error_explanation')/h2")).getText();
		
		assertEquals("4 errors prohibited this ad from being saved:", actual);
		formularz.Wyloguj();
	}
	
	@Test
	public void UzytkownikIstnieje(){
		Formularz formularz = new Formularz(driver);
		formularz.NowyUzytkownik();
		
		String actual = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
		
		assertEquals("Welcome to Ads App!", actual);
	}
	
	@Test
	public void BlednyNowyUzytkownik(){
		Formularz formularz= new Formularz(driver);
		formularz.BlednyNowyUzytkownik();
		
		String actual = driver.findElement(By.xpath("id('error_explanation')/ul/li")).getText();
		
		assertEquals("Password is too short (minimum is 6 characters)", actual);
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
