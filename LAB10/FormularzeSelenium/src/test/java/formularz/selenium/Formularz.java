package formularz.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Formularz {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[1]/div[2]/div/content/label[1]/div[1]/div[3]/div")
	private WebElement brazoweOczy;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div[1]/label/div[1]/div[2]")
	private WebElement ulubionyKolor1;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div[2]/label/div[1]/div[2]")
	private WebElement ulubionyKolor2;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div[3]/label/div[1]/div[2]")
	private WebElement ulubionyKolor3;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div[5]/label/div[1]/div[2]")
	private WebElement ulubionyKolor4;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/content")
	private WebElement wiek;

	@FindBy(how = How.XPATH, using = "//div[@data-value='>=18']/content")
	private WebElement ponizej18;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[3]/div[1]/div/div/content/span")
	private WebElement przeslij;

	@FindBy(id = "i.err.478502258")
	private WebElement brakOczu;

	@FindBy(id = "i.err.1986690651")
	private WebElement brakKoloru;

	@FindBy(id = "i.err.1126412717")
	private WebElement brakWieku;

	@FindBy(id = "i.err.1986690651")
	private WebElement zaDuzoKolorow;
	
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[1]/div[2]/div[2]")
	private WebElement poprawneWypelnienie;

	List<WebElement> listaDobra = new ArrayList<WebElement>();
	List<WebElement> listaBledna = new ArrayList<WebElement>();

	public Formularz(WebDriver driver) {
		this.driver = driver;
		driver.get("http://goo.gl/forms/ji37XaAL1s");
		PageFactory.initElements(driver, this);
	}

	public void zaznaczOczy() {
		brazoweOczy.click();
	}

	public void zaznaczKolory() {
		ulubionyKolor1.click();
		ulubionyKolor2.click();
		ulubionyKolor3.click();

		listaDobra.add(ulubionyKolor1);
		listaDobra.add(ulubionyKolor2);
		listaDobra.add(ulubionyKolor3);
	}

	public void wybierzWiek() {
		wiek.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// if the element is on top.
		js.executeScript("window.scrollTo(" + ponizej18.getLocation().x + "," + ponizej18.getLocation().y + ")");
		ponizej18.click();

	}

	public void zaDuzoKolorow() {
		ulubionyKolor1.click();
		ulubionyKolor2.click();
		ulubionyKolor3.click();
		ulubionyKolor4.click();

		listaBledna.add(ulubionyKolor1);
		listaBledna.add(ulubionyKolor2);
		listaBledna.add(ulubionyKolor3);
		listaBledna.add(ulubionyKolor4);
	}

	public String bladOczy() {
		return brakOczu.getText();
	}

	public String bladKolor() {
		return brakKoloru.getText();
	}

	public String bladWiek() {
		return brakWieku.getText();
	}

	public String bladZaDuzo(){
		return zaDuzoKolorow.getText();
	}
	public String poprawnie() {
		return poprawneWypelnienie.getText();
	}

	public void przeslijFormularz() {
		przeslij.click();
	}
}
