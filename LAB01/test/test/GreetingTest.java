package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingTest {

	private GreetingImpl test;
	
	@Before
	public void setup(){
		test = new GreetingImpl();
	}
	
	@Test
	public void GreetShouldReturnAValidOutput() {
		String result = test.greet("JUnit");
		
		assertNotNull(result);
		assertEquals("Hello JUnit", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void GreetShouldThrowAnException_Null(){
		String result = test.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void GreetShouldThrowAnException_Zero(){
		test.greet("");
	}
	
	@After
	public void teardown(){
		test = null;
	}
}
