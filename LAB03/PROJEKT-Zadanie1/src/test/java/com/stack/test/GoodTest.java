package com.stack.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.stack.Stack;

@RunWith(Suite.class)
@SuiteClasses({})
public class GoodTest {


private Stack stack;
	
	@Before
	public void setup(){
		stack = new Stack();
	}

	@Test
	public void MyPushCheck() {
		stack.MyPush(1);
		assertThat(stack.IsEmpty(), is(false));
	}
	
	@Test
	public void MyPopCheck() {
		stack.MyPush(2);
		stack.MyPop();
		assertThat(stack.IsEmpty(), is(true));
	}
	
	@Test
	public void MyPopException() {
		try{
			stack.MyPop();
			} 
		catch (IllegalArgumentException e) {
				assertThat(stack.IsEmpty(), is(false));
			}
		}
	
	@Test
	public void MyTopCheck() {
		stack.MyPush(20);
		stack.MyTop();
		assertThat(stack.MyTop().getValue(), is(20));
	}
	
	@Test
	public void IsEmptyCheck(){
		stack.MyPush(20);
		stack.MyPop();
		assertThat(stack.IsEmpty(), is(true));
	}

	@After
	public void teardown(){
		stack = null;
	}
	
	
}
