package com.example.webguidemo;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;

import com.example.webguidemo.Pages;

public class CalculatorSteps {

	private final Pages pages;

	public CalculatorSteps(Pages pages) {
		this.pages = pages;
	}
	@When("sum")
	public void whenSum(){
		 pages.home().findElement(By.id("BtnPlus")).click();
	}
	@When("adding <b>")
	public void whenAddingb(@Named("b") String value){
		pages.home().findElement(By.id("input")).sendKeys(value);
		pages.home().findElement(By.id("BtnCalc")).click();
	}
	@Then("total sum <sum>")
	public void thenTotalSumsum(@Named("sum") String sum){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 String result = pages.home().findElement(By.id("input")).getAttribute("value").toString();
		 assertEquals(sum, result);
	}
	@Given("first number <a>")
	public void givenFirstNumbera(@Named("a") String value){
		
		pages.home().open();
		pages.home().findElement(By.id("input")).sendKeys(value);
	}
	
}