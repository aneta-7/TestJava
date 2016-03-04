package com.stack;

import java.util.ArrayList;
import java.util.List;
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
	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		if(liczba.toString().length()==1)
			throw new NieudanyPsikusException();
		else if(liczba.toString().length() == 0)
			throw new NieudanyPsikusException();
		else{
			
			String liczbaNaString = liczba.toString();
			StringBuilder budowanie = new StringBuilder(liczbaNaString);
			int pozycja1 = generator.nextInt(liczbaNaString.length());
			int pozycja2;
			
			do
				pozycja2 = generator.nextInt(liczbaNaString.length());
			while (pozycja2 == pozycja1);
			char znak1 = budowanie.charAt(pozycja1);
			char znak2 = budowanie.charAt(pozycja2);
			budowanie.setCharAt(pozycja2, znak1);
			budowanie.setCharAt(pozycja1, znak2);
			Integer nowaLiczba = Integer.parseInt(budowanie.toString());
			
			
			return nowaLiczba;
		}
	}
	
	@Override
	public Integer Nieksztaltek(Integer liczba) {
		List<Integer> pozycje = new ArrayList<Integer>();
		String liczbaNaString = liczba.toString();
		StringBuilder budowanie = new StringBuilder(liczbaNaString);
		for (int i = 0; i < budowanie.length(); i++) {
			if (budowanie.charAt(i) == '3' || budowanie.charAt(i) == '7'
					|| budowanie.charAt(i) == '6')
				pozycje.add(i);
		}
		if (pozycje.size() == 0)
			return Integer.parseInt(budowanie.toString());
		else {
			int pozycja = generator.nextInt(pozycje.size());
			if (budowanie.charAt(pozycje.get(pozycja)) == '3')
				budowanie.setCharAt((pozycje.get(pozycja)), '8');
			else if (budowanie.charAt(pozycje.get(pozycja)) == '7')
				budowanie.setCharAt((pozycje.get(pozycja)), '1');
			else if (budowanie.charAt(pozycje.get(pozycja)) == '6')
				budowanie.setCharAt((pozycje.get(pozycja)), '9');
			Integer nowaLiczba = Integer.parseInt(budowanie.toString());
			
			return nowaLiczba;
		}
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
	
}
