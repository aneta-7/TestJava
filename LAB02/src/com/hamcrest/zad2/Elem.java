package com.hamcrest.zad2;


/*pojedynczy element*/
public class Elem {
	int value;
	Elem next;


	public Elem(int x, Elem n) {
		next = n;
		value = x;
	}

	public Elem getNext() {
		return next;
	}

	public int getValue() {
		return value;
	}
}
