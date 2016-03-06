package com.stack.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.stack.Kontrakt;

@RunWith(Parameterized.class)
public class NiekształtekZParametrem {

	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { 11, 11 }, { 28, 23 },  { 22, 22 }, { 82, 32 },  {1592,1562},
           });
    }
	
	private Integer oczekiwana;
    private Integer wejsciowa;
   
    public NiekształtekZParametrem(Integer oczekiwana,Integer wejsciowa) {
        this.oczekiwana = oczekiwana;
        this.wejsciowa = wejsciowa;
    }
    
    @Test
    public void TestZParametrem() {
             Kontrakt kontrakt = new Kontrakt();
             assertEquals(oczekiwana, (kontrakt.Nieksztaltek(wejsciowa)));	
    }

}
