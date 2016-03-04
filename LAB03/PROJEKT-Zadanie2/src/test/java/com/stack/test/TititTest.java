package com.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

	@Test(expected = IllegalArgumentException.class)
	public void zero(){
		kontrakt.Titit(0);
	}
	
	@Test
	public void dzielPrzez2(){
		assertThat(true, equalTo(kontrakt.Titit(2)));
	}
	
	@Test
	public void dzielPrzez3(){
		assertThat(true, equalTo(kontrakt.Titit(3)));
	}
	
	@Test
	public void dzielPrzez5(){
		assertThat(false, equalTo(kontrakt.Titit(5)));
	}
}
