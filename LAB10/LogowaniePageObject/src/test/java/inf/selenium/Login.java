package inf.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(name="session[email]")
	private WebElement emailTx;
	
	@FindBy(name="session[password]")
	private WebElement passwordTx;
	
	@FindBy(name="commit")
	private WebElement loginButton;
	
	public Login(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
	  emailTx.sendKeys(email);
	  passwordTx.sendKeys(password);
	  loginButton.click();
	}
	
}
