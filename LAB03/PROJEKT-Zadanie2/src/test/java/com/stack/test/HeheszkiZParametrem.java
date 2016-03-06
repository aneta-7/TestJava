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
public class HeheszkiZParametrem {

	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { 1, 2 }, {  6,8 }, { 1579, 4444 }, 
           });
    }

	private Integer oczekiwana;
    private Integer wejsciowa;
   
    public HeheszkiZParametrem(Integer oczekiwana,Integer wejsciowa) {
                                    this.oczekiwana = oczekiwana;
                                    this.wejsciowa = wejsciowa;
    }
    
    @Test
    public void testZParametrem(){
             Kontrakt kontrakt = new Kontrakt();
    
             assertThat(kontrakt.Heheszki(wejsciowa), greaterThanOrEqualTo(0));
     		 assertThat(kontrakt.Heheszki(wejsciowa), lessThan(wejsciowa));
    }

}
