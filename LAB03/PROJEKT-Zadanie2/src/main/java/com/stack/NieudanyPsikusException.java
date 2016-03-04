package com.stack;

public class NieudanyPsikusException extends Exception {

	 public void NieudanyPsikusException(){
	       System.out.println("Zgłoszenie wyjątku NieudanyPsikusException");
	       throw new NullPointerException();
	     }	 
}
