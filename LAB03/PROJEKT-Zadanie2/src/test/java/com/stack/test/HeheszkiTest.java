package com.stack.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.stack.Kontrakt;

public class HeheszkiTest {

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
	public void test(){
		
		
	}

}
