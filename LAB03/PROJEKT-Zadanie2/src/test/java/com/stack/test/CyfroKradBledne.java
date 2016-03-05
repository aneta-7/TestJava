package com.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.stack.Kontrakt;

public class CyfroKradBledne {

	private static Kontrakt kontrakt;
	
	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}

	@After 
	public void po(){
		kontrakt = null;
	}

	@Test(expected = NullPointerException.class)
	public void pusty(){
		Integer liczba = null;
		assertNull(kontrakt.CyfroKrad(liczba));
	}
}
