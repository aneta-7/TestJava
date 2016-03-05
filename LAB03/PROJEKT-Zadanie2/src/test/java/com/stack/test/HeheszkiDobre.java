package com.stack.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stack.Kontrakt;

public class HeheszkiDobre {

	private Kontrakt kontrakt;

	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}

	@After
	public void po(){
		kontrakt = null;
	}
	
	@Test
	public void liczbaDodatnia(){
		Integer liczba = 3;
		assertThat(kontrakt.Heheszki(liczba), lessThan(3));
	}

}
