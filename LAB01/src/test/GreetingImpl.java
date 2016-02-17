package test;

import org.junit.Test;

public class GreetingImpl implements Greeting {
	
	public String greet(String name){
		if(name == null || name.length() ==0 ){
			throw new IllegalArgumentException();
		}
		else
			return "Hello " +name;
	}

}
