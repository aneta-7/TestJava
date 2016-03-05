package com.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stack.Kontrakt;

public class TititBledne {

	private Kontrakt kontrakt;
	
	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}
	
	@After
	public void po(){
		kontrakt = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void zero(){
		kontrakt.Titit(0);
	}

	@Test(expected = NullPointerException.class)
	public void pusty(){
		Integer liczba = null;
		kontrakt.Titit(liczba);
	}
}
