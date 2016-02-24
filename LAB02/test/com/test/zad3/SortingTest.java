package com.test.zad3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hamcrest.zad3.Sorting;


public class SortingTest {

	private Sorting sort;
	
	@Before 
	public void setup(){
		sort = new Sorting();		
	}
	@Test
	public void teSameElementy() {
		int[] arr = {1, 1, 1, 1};
		int[] expected = {1, 1, 1, 1};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	@Test 
	public void pustaLista(){
		int[] arr = null;
		sort.sortowanie(arr);
		assertThat(arr, is(nullValue()));
	}
	@Test
	public void zeroElementów() {
		int[] arr = {};
		int[] expected = {};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
		
	}
	@Test
	public void rosn¹co() {
		int[] arr = {1, 2, 3, 4};
		int[] expected = {1, 2, 3, 4};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	@Test
	public void malej¹co() {
		int[] arr = {4, 3, 2, 1};
		int[] expected = {1, 2, 3, 4};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	
	@Test
	public void wymieszane() {
	
		int[] arr = {2, 3, 1, 4, 8, 5, 6, 9, 7};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	
	@Test
	public void dwaElementy() {
		int[] arr = {2,1};
		int[] expected = {1, 2};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	@Test
	public void jedenElement() {
		int[] arr = {32};
		int[] expected = {32};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	
	@Test
	public void wszystkieUjemne() {
		int[] arr = {-2,-3,-4,-55};
		int[] expected = {-55,-4,-3,-2};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}
	
	@Test
	public void dodatnieUjemne(){
		int[] arr = {2,-3,-4,-55, 3,-12,0};
		int[] expected = {-55,-12,-4,-3,0,2,3};
		sort.sortowanie(arr);
		assertThat(arr, is(expected));
	}

	@After
	public void teardown(){
		sort = null;
	}
}
