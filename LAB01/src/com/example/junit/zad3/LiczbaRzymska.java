package com.example.junit.zad3;

public class LiczbaRzymska {

	int liczba; 
	public LiczbaRzymska(int liczba){
		this.liczba = liczba;
	}
	
	
	public String toString(int liczba){
		
		if (liczba < 1 || liczba >3999)
			return "-1";
		
		
		String tabRzymska[]={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	    int tabArabska[]={1,4,5,9,10,40,50,90,100,400,500,900,1000};
	    String wynik="";
	    int ile=liczba;
	    for(int i=12;i>=0;i--)
	        while(ile>=tabArabska[i]){
	            ile=ile-tabArabska[i];
	            wynik=wynik+tabRzymska[i];
	        }		
		return wynik;
	}
	
}
