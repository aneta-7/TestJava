package com.example.junit.zad1;

public class NWD {

	public int euclides(int a, int b){
		if(a < 0 || b < 0)
			throw new ArithmeticException();
		if(a==0)
			return b;
		else if (b==0)
			return a;	
		else{
		while(a != b){
			if(a>b)
				a -= b;
			else
				b -=a;
		}
		return a;
		}
	}
}
