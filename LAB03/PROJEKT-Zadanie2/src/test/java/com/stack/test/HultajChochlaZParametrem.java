package com.stack.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.stack.Kontrakt;
import com.stack.NieudanyPsikusException;

@RunWith(Parameterized.class)
public class HultajChochlaZParametrem {
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { 111, 111 }, {77777,77777} ,{21,12},{ 222, 222 }, {32,23}});
    }

	private Integer oczekiwany;
    private Integer wejsciowy;
   
    public HultajChochlaZParametrem(Integer oczekiwany,Integer wejsciowy) {
                                    this.oczekiwany = oczekiwany;
                                    this.wejsciowy = wejsciowy;
    }

    @Test
    public void testZParametrem() throws NieudanyPsikusException{
             Kontrakt kontrakt = new Kontrakt();
            
             assertEquals(oczekiwany, (kontrakt.HultajChochla(wejsciowy)));	
    }
}
