package com.test.zad1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

import com.hamcrest.zad1.Calculator;


public class CalculatorTest {
	
		private Calculator calc = new Calculator();
		
		@Test
		public void addCheck(){
			int result = calc.add(3, 2);
			assertThat(result, is(5));
		}
		
		@Test
		public void subCheck(){
			int result = calc.sub(3, 2);
			assertThat(result, is(1));
		}
		
		@Test
		public void multiCheck(){
			int result = calc.multi(3, 2);
			assertThat(result, is(6));
		}
		
		@Test
		public void divCheck(){
			int result = calc.div(3, 2);
			assertThat(result, is(1));
		}
		
		@Test
		public void greaterCheck(){
			boolean result = calc.greater(3, 2);
			assertThat(result, hasToString(equalTo("true")));
		}
		
}
