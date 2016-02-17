package com.example.junit.zad2i3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.junit.zad2i3.Calculator;

public class CalculatorTest {

	//SUT- system under test
	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck(){
		assertEquals(5, calc.add(3, 2));
	}
	
	@Test
	public void subCheck(){
		assertEquals(1, calc.sub(3, 2));
	}
	
	@Test
	public void multiCheck(){
		assertEquals(6, calc.multi(3, 2));
	}
	
	@Test
	public void divCheck(){
		assertEquals(1, calc.div(3, 2));
	}
	
	@Test
	public void greaterCheck(){
		assertTrue(calc.greater(3, 2));
	}
	
	@Test
	public void greaterCheck2(){
		assertFalse(calc.greater(2, 3));
	}
	
	@Test(expected = ArithmeticException.class)
	public void divZeroCheck(){
		calc.div(1, 0);
	}
	
}
