package projekt.tests;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class EmailSteps {

	private final Pages pages;

	public EmailSteps(Pages pages) {
		this.pages = pages;
	}

	@When("send data")
	public void whenSendData() {
		pages.heroku().findElement(By.id("ad_name")).sendKeys("nowy produkt");
		pages.heroku().findElement(By.id("ad_description")).sendKeys("projekt selenium + jbehave");
		pages.heroku().findElement(By.id("ad_price")).sendKeys("2.43");
		pages.heroku().findElement(By.id("ad_seller_id")).sendKeys("1");
		pages.heroku().findElement(By.id("ad_email")).sendKeys("email@email.pl");
		pages.heroku().findElement(By.id("ad_url_img")).sendKeys("urlnowegoproduktu.com");
	}

	@Then("user is login")
	public void thenUserIsLogin() {
		pages.heroku().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
		String title = pages.heroku().getTitle();

		assertEquals("Aneta | Ads app", title);
		pages.heroku().findElement(By.xpath("/html/body/header/div/nav/ul/li[5]/a")).click();
		pages.heroku().findElement(By.xpath("/html/body/header/div/nav/ul/li[5]/ul/li[4]/a")).click();
	}

	@When("send name")
	public void whenSendName() {
		pages.heroku().findElement(By.id("session_email")).sendKeys("aneta.stypa7@wp.pl");
	}

	@When("click create")
	public void whenClickCreate() {
		pages.heroku().findElement(By.xpath("id('new_ad')/div[7]/input")).click();
	}

	@Then("user creane new ad")
	public void thenUserCreaneNewAd() {
		String create = pages.heroku().findElement(By.xpath("/html/body/div/div")).getText();
		assertEquals("Ad was successfully created.", create);
		
		pages.heroku().findElement(By.xpath("/html/body/div/a[2]")).click();
		pages.heroku().findElement(By.xpath("/html/body/div/div[2]/ul/li[13]/a")).click();
		
		String title = pages.heroku().findElement(By.xpath("//td[1]/a")).getText();
		assertEquals("nowy produkt", title);
	}

	@When("send password")
	public void whenSendPassword() {
		pages.heroku().findElement(By.id("session_password")).sendKeys("123456");
	}

	@Given("user is login")
	public void givenUserIsLogin() {
		pages.heroku().open();
		pages.heroku().findElement(By.xpath("/html/body/header/div/nav/ul/li[4]/a")).click();
		
		pages.heroku().findElement(By.id("session_email")).sendKeys("aneta.stypa7@wp.pl");
		pages.heroku().findElement(By.id("session_password")).sendKeys("123456");
		
		pages.heroku().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
		String title = pages.heroku().getTitle();

		assertEquals("Aneta | Ads app", title);
		
	}

	@Given("click login")
	public void givenClickLogin() {
		pages.heroku().open();
		pages.heroku().findElement(By.xpath("/html/body/header/div/nav/ul/li[4]/a")).click();
	}

	@When("go to create")
	public void whenGoToCreate() {
		pages.heroku().findElement(By.xpath("/html/body/header/div/nav/ul/li[3]/a")).click();
		pages.heroku().findElement(By.xpath("/html/body/div/a")).click();
		
	}
}
