import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;

import com.example.webguidemo.Pages;
public class MySteps{
	
private final Pages pages;
	
	public MySteps(Pages pages){
		this.pages=pages;
	}
	
	@When("user send badPassword")
	public void whenUserSendBadPassword(){
		pages.badLogin().findElement(By.id("session_password")).sendKeys("bad");
	}
	@Then("user login")
	public void thenUserLogin(){
		 pages.login().findElement(By.id("session_email")).sendKeys("aneta.stypa7@wp.pl");
	}
	@When("user send password")
	public void whenUserSendPassword(){
		 pages.login().findElement(By.id("session_password")).sendKeys("123456");
	}
	@When("user click button ")
	public void whenUserClickButton(){
		pages.login().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
	}
	@When("user send badLogin ")
	public void whenUserSendBadLogin(){
		pages.badLogin().findElement(By.id("session_email")).sendKeys("bad@bad.pl");
	}
	@Then("user not login")
	public void thenUserNotLogin(){
		String bad = pages.badLogin().findElement(By.xpath("/html/body/div/div[1]")).getText();
		assertEquals("Invalid email/password combination", bad); 
	}
	@Given("user on Login page")
	public void givenUserOnLoginPage(){
		 pages.badLogin().open();
	}
	@When("user click button ")
	public void whenUserClickButton(){
		pages.badLogin().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
	}
	@Given("user on Login page")
	public void givenUserOnLoginPage(){
		 pages.login().open();
	}
	@When("user send login")
	public void whenUserSendLogin(){
		pages.login().findElement(By.id("session_email")).sendKeys("aneta.stypa7@wp.pl"); 
	}
}