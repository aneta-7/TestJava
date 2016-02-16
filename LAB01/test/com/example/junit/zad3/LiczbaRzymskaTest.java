package com.example.junit.zad3;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiczbaRzymskaTest {

	int liczba;
	private LiczbaRzymska licz = new LiczbaRzymska(liczba); 
	
	@Test
	public void rzymskaCheck(){
		assertEquals("XI", licz.toString(11));
		assertEquals("XV", licz.toString(15));
		assertEquals("VI", licz.toString(6));
		assertEquals("LI", licz.toString(51));
	}
	
	@Test 
	public void ujemnaCheck(){
		assertEquals("-1", licz.toString(-1222));
	}
}
