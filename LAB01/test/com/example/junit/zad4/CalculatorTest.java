package com.example.junit.zad4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.junit.zad4.Calculator;

public class CalculatorTest {
private Calculator calc = new Calculator();
private static final double delta = 1e-15;	

	@Test
	public void addCheck(){
		assertEquals(5.0, calc.add(3.0, 2.0), delta);
	}
	
	@Test
	public void addCheck2(){
		assertEquals(5.64, calc.add(3.32, 2.32), delta);
	}
	
	@Test
	public void subCheck(){
		assertEquals(1.0, calc.sub(3.0, 2.0), delta);
	}
	
	@Test
	public void multiCheck(){
		assertEquals(6.0, calc.multi(3.0, 2.0), delta);
	}
	
	@Test
	public void divCheck(){
		assertEquals(1.5, calc.div(3.0, 2.0), delta);
	}
	
	@Test
	public void divCheck2(){
		assertEquals(3.1, calc.div(3.1, 1), delta);
	}
	
	@Test
	public void greaterCheck(){
		assertTrue(calc.greater(3.0, 2.0));
	}
	
	@Test
	public void greaterCheck2(){
		assertFalse(calc.greater(2.0, 3.0));
	}
	
}
