package com.example.junit.zad1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import test.GreetingImpl;

public class NWDTest {

	private NWD test;
	
	@Before
	public void setup(){
		test = new NWD();
	} 
	
	@Test
	public void nwd()
	{
		assertEquals(1, test.euclides(12, 1));
		assertEquals(12, test.euclides(12, 12));
		assertEquals(12, test.euclides(60, 12));
		assertEquals(12, test.euclides(12, 60));
		assertEquals(2, test.euclides(2, 100));
		assertEquals(1, test.euclides(1, 0));
		assertEquals(22, test.euclides(0, 22));
	}
	
	@Test(expected = ArithmeticException.class)
	public void nwd_error(){
		assertEquals(true, test.euclides(-1, 3));
		assertEquals(true, test.euclides(43, -1));
		assertEquals(true, test.euclides(0, 0));
	}
	
	
	
	
	
	
}
