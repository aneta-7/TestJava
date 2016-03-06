package com.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stack.Kontrakt;
import com.stack.NieudanyPsikusException;

public class HultajChochlaBledne {

	private Kontrakt kontrakt;
	
	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}
	
	@After 
	public void po(){
		kontrakt = null;
	}
	
	@Test(expected = NieudanyPsikusException.class)
	public void jedenElement() throws NieudanyPsikusException{
		kontrakt.HultajChochla(1);
	}
	
	@Test(expected = NullPointerException.class)
	public void pusty() throws NieudanyPsikusException{
		Integer liczba = null;
		kontrakt.HultajChochla(liczba);
	}

}
