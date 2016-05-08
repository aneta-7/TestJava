package projekt.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Formularz {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[4]/a")
	private WebElement log;

	@FindBy(id = "session_email")
	private WebElement login;
	
	@FindBy(id = "session_password")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/input[5]")
	private WebElement clickLogin;
	
	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[5]/ul/li[4]/a")
	private WebElement logout;
	
	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[5]/a")
	private WebElement account;
	
	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[4]/a")
	private WebElement users;
	
	@FindBy(how = How.XPATH, using ="/html/body/header/div/nav/ul/li[3]/a")
	private WebElement ads;
	
	@FindBy(how = How.XPATH, using ="/html/body/div/a")
	private WebElement newAd;
	
	@FindBy(id = "ad_name")
	private WebElement adName;
	
	@FindBy(id ="ad_description")
	private WebElement adDescription;
	
	@FindBy(id = "ad_price")
	private WebElement adPrice;
	
	@FindBy(id = "ad_seller_id")
	private WebElement adSeller;
	
	@FindBy(id = "ad_email")
	private WebElement adEmail;
	
	@FindBy(id ="ad_url_img")
	private WebElement adUrl;
	
	@FindBy(how = How.XPATH, using ="id('new_ad')/div[7]/input")
	private WebElement createAd;
	
	@FindBy(how = How.XPATH, using ="/html/body/div/table/tbody/tr[1]/td[6]/a")
	private WebElement editAd;
	
	@FindBy(how = How.XPATH, using ="//div[7]/input")
	private WebElement updateAd;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/a")
	private WebElement signUp;
	
	@FindBy(id = "user_name")
	private WebElement userName;
	
	@FindBy(id = "user_email")
	private WebElement userEmail;
	
	@FindBy(id = "user_password")
	private WebElement userPassword;
	
	@FindBy(id = "user_password_confirmation")
	private WebElement passwordConfirmation;
	
	@FindBy(how = How.XPATH, using = "id('new_user')/input[7]")
	private WebElement createAccount;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[5]/td[7]/a")
	private WebElement destroy;
	
	@FindBy(how = How.XPATH, using ="/html/body/div/div[1]")
	public WebElement actualBadLogin;
	
	public Formularz(WebDriver driver) {
		this.driver = driver;
		driver.get("https://anetashop2.herokuapp.com");
		PageFactory.initElements(driver, this);
	}

	public void Zaloguj() {
		log.click();
		login.sendKeys("aneta.stypa7@wp.pl");
		password.sendKeys("123456");
		clickLogin.click();
	}
	
	public void BlednieZaloguj() {
		log.click();
		login.sendKeys("aneta.stypa7@wp.pl");
		password.sendKeys("12");
		clickLogin.click();
	}
	
	public void Wyloguj(){
		account.click();
		logout.click();
	}
	
	public void Uzytkownicy(){
		users.click();
	}
	
	public void DodajProdukt(){
		ads.click();
		newAd.click();
		
		adName.sendKeys("nowy produkt");
		adDescription.sendKeys("opis nowego produktu");
		adPrice.sendKeys("2.43");
		adSeller.sendKeys("3");
		adEmail.sendKeys("nowy@nowy.pl");
		adUrl.sendKeys("urlnowegoproduktu.com");
		
		createAd.click();
	}
	
	public void BlednieDodajProdukt(){
		ads.click();
		newAd.click();
			
		createAd.click();
	}
	
	public void EdytujOgloszenie(){
		ads.click();
		
		editAd.click();
		adName.clear();
		adName.sendKeys("edycja");
		adDescription.clear();
		adDescription.sendKeys("edycja");
		
		updateAd.click();
	}
	
	public void BlednieEdytujOgloszenie(){
		ads.click();
		
		editAd.click();
		adName.clear();
		adDescription.clear();
		
		updateAd.click();
	}

	public void NowyUzytkownik(){
		signUp.click();
		
		userName.sendKeys("Aneta");
		userEmail.sendKeys("aneta.stypa7@wp.pl");
		userPassword.sendKeys("123456");
		passwordConfirmation.sendKeys("123456");
		
		createAccount.click();
	}
	
	public void BlednyNowyUzytkownik(){
		signUp.click();
		
		userName.sendKeys("Aneta");
		userEmail.sendKeys("aneta.stypa7@wp.pl");
		userPassword.sendKeys("123");
		passwordConfirmation.sendKeys("123");
		
		createAccount.click();
	}
	
	public void ProbaDodania(){
		ads.click();
		newAd.click();
	}
	
	public void UsunOgloszenie(){
		ads.click();
		destroy.click();
	}
}
