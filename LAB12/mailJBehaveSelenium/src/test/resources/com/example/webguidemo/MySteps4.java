import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;

import com.example.webguidemo.Pages;
public class MySteps4{
	
	private final Pages pages;

	public MySteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("a login user in onet")
	public void givenALoginUserInOnet(){
		 pages.onet().open();
		 pages.onet().findElement(By.id("f_login")).sendKeys("testowanie2016@onet.pl");
		 pages.onet().findElement(By.id("f_password")).sendKeys("2016Testowanie");
		 pages.onet().findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();
	}
	@Then("userInteria get a message")
	public void thenUserInteriaGetAMessage(){
		 pages.wp().open();
		 pages.wp().findElement(By.id("iLogin")).sendKeys("testowanie2016@interia.pl");
		 pages.wp().findElement(By.id("iPassword")).sendKeys("2016Testowanie");
		 pages.wp().findElement(By.xpath("id('loginAccountForm')/div/button")).click();
		 
		 pages.wp().findElement(By.xpath("id('header')/div[2]/div/div/div/a[1]/span[1]")).click();
		 pages.wp().findElement(By.xpath("id('header_login')/ul/li[2]/a")).click();
		 
		 pages.wp().findElement(By.xpath("id('ng-app')/body/section[5]/section[1]/div/section/ul/li[2]/a")).click();
		 String title = pages.wp().findElement(By.xpath("id('ng-app')/body/section[4]/div[1]/div[1]/section/ul/li[1]/div[2]/div[1]/div/span")).getText();
		 
		 assertEquals("nowa",title);
	}
	@When("click wyslij")
	public void whenClickWyslij(){
		 pages.onet().findElement(By.id("newmail-actions-top-send")).click();
	}
	@When("send odbiorca")
	public void whenSendOdbiorca(){
		 pages.onet().findElement(By.id("newmail-txtmailto-multipleInput")).sendKeys("testowanie2016@interia.pl");
	}
	@When("send tytul")
	public void whenSendTytul(){
		 pages.onet().findElement(By.id("newmail-subject")).sendKeys("testowy email");
	}
	@When("click NowyList")
	public void whenClickNowyList(){
		pages.onet().findElement(By.xpath("id('NewMail-button')/span")).click(); 
	}
	@When("send tresc ")
	public void whenSendTresc(){
		pages.onet().findElement(By.xpath("id('tinymce')/div")).sendKeys("test");
	}
}