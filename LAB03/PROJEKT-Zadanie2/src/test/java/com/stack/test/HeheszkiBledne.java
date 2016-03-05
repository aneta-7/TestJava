package com.stack.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stack.Kontrakt;

public class HeheszkiBledne {

	private Kontrakt kontrakt;

	@Before
	public void przed(){
		kontrakt = new Kontrakt();
	}

	@After
	public void po(){
		kontrakt = null;
	}

	@Test(expected = NullPointerException.class)
	public void wartoscNull() {
		Integer liczba = null;
		assertThat(kontrakt.Heheszki(liczba), is(nullValue()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void wartoscZero(){
		Integer liczba = 0;
		assertThat(kontrakt.Heheszki(liczba), greaterThan(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void liczbaUjemna(){
		Integer liczba = -3;
		assertThat(kontrakt.Heheszki(liczba), lessThan(liczba));
	}
	
	@Test(expected = AssertionError.class)
	public void liczbaDodatnia2(){
		Integer liczba = 23432;
		assertThat(kontrakt.Heheszki(liczba), lessThan(1));
	}

}
