package inf.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AboutTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AnetaS\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void serwisGlownyTest() {
		driver.get("https://inf.ug.edu.pl/");
		driver.findElement(By.linkText("Uniwersytet Gdañski")).click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));

		assertEquals("Serwis g³ówny UG", driver.getTitle());

	}
	@Test
	public void aboutTest() {
		driver.get("https://inf.ug.edu.pl/");
		driver.findElement(By.linkText("Uniwersytet Gdañski")).click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		assertEquals("Serwis g³ówny UG", driver.getTitle());

		driver.findElement(By.id("edit-search-block-form--2")).sendKeys("egzamin");
		driver.findElement(By.className("form-submit")).click();
		
		assertEquals("Szukaj | Serwis g³ówny UG", driver.getTitle());
		
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
