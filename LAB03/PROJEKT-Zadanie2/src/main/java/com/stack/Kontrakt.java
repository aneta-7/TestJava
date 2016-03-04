package com.stack;

import java.util.Random;

public class Kontrakt implements Psikus{

	
	private Random generator = new Random();
	
	@Override
	public Integer CyfroKrad(Integer liczba) {
		if(liczba.toString().length() == 1)
			return null;
		else if(liczba.toString().length() == 0)
			return null;
		
		else{
			String liczbaNaString = liczba.toString();
			StringBuilder budowanie = new StringBuilder(liczbaNaString);
			int pozycja = generator.nextInt(liczbaNaString.length());
			budowanie.deleteCharAt(pozycja);
			int nowaLiczba = Integer.parseInt(budowanie.toString());
			return nowaLiczba;
		}
		
	}

	@Override
	public Integer Nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Heheszki(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Titit(Integer liczba_dziel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

}
