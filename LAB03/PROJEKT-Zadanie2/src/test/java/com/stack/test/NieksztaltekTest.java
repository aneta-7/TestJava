package com.stack.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.stack.Kontrakt;

public class NieksztaltekTest {

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
	public void trzyTest(){
		assertThat(kontrakt.Nieksztaltek(123), is(128));	
	}
	
	@Test
	public void siedemTest(){
		assertThat(kontrakt.Nieksztaltek(172), is(112));
	}

	@Test
	public void szescTest(){
		assertThat(kontrakt.Nieksztaltek(16), is(19));
	}
	
	@Test
	public void trzySiedemTest(){
		assertThat(kontrakt.Nieksztaltek(371), either(is(871)).or(is(311)));
	}
	
	@Test
	public void trzySzescTest(){
		assertThat(kontrakt.Nieksztaltek(361), either(is(861)).or(is(391)));
	}
	
	@Test
	public void siedemSzescTest(){
		assertThat(kontrakt.Nieksztaltek(761), either(is(161)).or(is(791)));
	}
	
	@Test
	public void trzySiedemSzescTest(){
		assertThat(kontrakt.Nieksztaltek(376), either(is(876)).or(is(316)).or(is(379)));
	}
	
	@Test
	public void jednoTrzy(){
		assertThat(kontrakt.Nieksztaltek(3), is(8));
	}
	
	@Test
	public void dwaTrzy(){
		assertThat(kontrakt.Nieksztaltek(33), either(is(83)).or(is(38)));
	}
	
	@Test
	public void inneTest(){
		assertThat(kontrakt.Nieksztaltek(442), is(442));
	}
}