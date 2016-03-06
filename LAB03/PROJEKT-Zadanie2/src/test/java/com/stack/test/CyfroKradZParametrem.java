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
public class CyfroKradZParametrem {

	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { 22, 222 }, {  null,8 }, { 444, 4444 }, 
           });
    }

	private Integer oczekiwana;
    private Integer wejsciowa;
   
    public CyfroKradZParametrem(Integer oczekiwana,Integer wejsciowa) {
                                    this.oczekiwana = oczekiwana;
                                    this.wejsciowa = wejsciowa;
    }
    
    @Test
    public void testZParametrem(){
             Kontrakt kontrakt = new Kontrakt();
            
             assertEquals(oczekiwana, (kontrakt.CyfroKrad(wejsciowa)));	
    }

}
