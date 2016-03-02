package com.stack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stack.PsikusImpl;

public class StackTest {

	private PsikusImpl stack;
	
	@Before
	public void setUp(){
		stack = new PsikusImpl();
	}
	
	@After
	public void tearDown(){
		stack = null;
	}
	
	@Test
	public void isEmptyCheck(){
		assertTrue(stack.IsEmpty());
		
		stack.MyPush(45);
		assertFalse(stack.IsEmpty());
	}
	
	@Test
	public void pushAndTopCheck(){
		int value = 5;
		stack.MyPush(value);
		assertEquals(value, stack.MyTop());
		
		value =+5;
		
		assertEquals(value, stack.MyTop());
	}
	
	@Test
	public void popCheck(){
		int x = 4;
		int y = 6;
		int z = 5;
		
		stack.MyPush(x);
		stack.MyPush(y);
		stack.MyPush(z);
		
		assertEquals(z, stack.MyTop());
		
		stack.MyPop();
		assertEquals(y, stack.MyTop());
	}
	
	@Test
	public void maxCheck(){
		int max = Integer.MAX_VALUE;
		stack.MyPush(max);
		assertEquals(max, stack.MyTop());
	}
	
	@Test 
	public void minCheck(){
		int min = Integer.MIN_VALUE;
		stack.MyPush(min);
		assertEquals(min, stack.MyTop());
		stack.MyPop();
		assertTrue(stack.IsEmpty());
	}
	
	@Test(expected = NullPointerException.class)
	public void  nullTopCheck(){
		stack.MyTop();
	}
	
	@Test(expected = NullPointerException.class)
	public void nullPopCheck(){
			stack.MyPop();	
	}
}
