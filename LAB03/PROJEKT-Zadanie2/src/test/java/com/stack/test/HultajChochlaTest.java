package com.stack.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.stack.Kontrakt;
import com.stack.NieudanyPsikusException;

public class HultajChochlaTest {

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
	
	@Test
	public void trzyLiczby() throws NieudanyPsikusException{
		Integer liczba = 123;
		assertThat(kontrakt.HultajChochla(liczba), either(is(132)).or(is(213)).or(is(321)));	
	}
	
	@Test
	public void dwieLiczby() throws NieudanyPsikusException{
		Integer liczba = 12;
		assertThat(kontrakt.HultajChochla(liczba), is(21));
	}	
}
