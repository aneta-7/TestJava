package inf.selenium;



import static org.junit.Assert.*;

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
	public void badLogin()
	{
		driver.get("https://anetashop2.herokuapp.com/login");
		Login login = new Login(driver);
		login.login("aneta@wp.pl", "1234");
		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();

		assertEquals("Invalid email/password combination", actual);
	}
	
	@Test
	public void correctLogin()
	{
		driver.get("https://anetashop2.herokuapp.com/login");
		Login login = new Login(driver);
		login.login("aneta.stypa7@wp.pl", "123456");
		

		assertEquals("Aneta | Ads app", driver.getTitle());
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
