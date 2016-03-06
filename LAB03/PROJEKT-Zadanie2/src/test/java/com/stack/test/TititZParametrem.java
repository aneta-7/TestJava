package com.stack.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.stack.Kontrakt;

@RunWith(Parameterized.class)
public class TititZParametrem {
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 {true, 10}, {true, 2}, {true, 3}, {false, 7}
           });
    }

	private boolean oczekiwana;
    private Integer liczba_dziel;
   
    public TititZParametrem (boolean oczekiwana,Integer liczba_dziel) {
                                    this.oczekiwana = oczekiwana;
                                    this.liczba_dziel = liczba_dziel;
    }
    
    @Test
    public void testZParametrem(){
             Kontrakt kontrakt = new Kontrakt();
            
             assertThat(kontrakt.Titit(liczba_dziel), is(oczekiwana));
    }

}
