package com.stack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.stack.Kontrakt;

public class CyfrokradTest {

	private static Kontrakt kontrakt;
	
	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}

	@After 
	public void po(){
		kontrakt = null;
	}

	@Test
	public void jednaCyfra(){
		assertNull(kontrakt.CyfroKrad(1));
	}
	
	@Test
	public void dwieCyfry() {
		assertThat(kontrakt.CyfroKrad(10), either(is(1)).or(is(0)));
	}
	
	@Test
	public void trzyCyfry(){
		assertEquals(3, kontrakt.CyfroKrad(1234).toString().length());
	}
}
