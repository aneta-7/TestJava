package com.hamcrest.zad2;

import java.util.ArrayList;
import java.util.List;


public class MyStack {
	Elem start;

	public MyStack() {
		start = null;
	}

	public Elem MyTop() {
		return start;
	}

	public void MyPush(int x) {
		Elem temp = new Elem(x, start);
		start = temp;
	}

	public void MyPop() {
		if (start != null) {
			start = start.getNext();
		} 
	}

	public boolean IsEmpty(){
		if(start == null){
			return true;
		}else {
			return false;
		}
	}

}