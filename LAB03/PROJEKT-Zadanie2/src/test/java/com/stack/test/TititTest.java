package com.stack.test;

import org.junit.After;
import org.junit.Before;

import com.stack.Kontrakt;

public class TititTest {

	private Kontrakt kontrakt;
	
	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}
	
	@After
	public void po(){
		kontrakt = null;
	}

}
