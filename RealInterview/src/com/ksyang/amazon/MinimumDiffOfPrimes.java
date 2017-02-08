package com.ksyang.amazon;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * You are given an array of integers. Find the minimum difference between 
 * two prime numbers(Positive or negative) in the array when present with 
 * minimum time complexity and provide the test data to test the this code.
 */
public class MinimumDiffOfPrimes {
	
	public static void main(String[] args){
		
//		int[] numbers = {101,-113,1,45,78,-2,-3,7};
		int[] numbers = {10, 8, 3, 4, 16, 32, 44, 15, 127, 45, 14, 19, 16, 12, 100, 101};
		List<Integer> primes = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		
		//sqrt(n)*sqrt(n)
		for(int i=0; i<numbers.length; i++){
			if(isPrime(numbers[i])){
				for(int j=0; j<primes.size(); j++){
					int diff = Math.abs(numbers[i]-primes.get(j));
					if(diff<min) min = diff;
				}
				primes.add(numbers[i]);
			}
		}
		
		System.out.println(min);
		
	}
	
	//n*sqrt(n)
	static boolean isPrime(int num){
		
		if(num<0) num = -num;
		if(num == 1) return false;
		if(num == 2) return true;
		
		if((num&1)==0) return false;
		
		int sqrt = (int) Math.sqrt(num);
		
		for(int i=3; i<=sqrt; i=i+2){
			if(num%i == 0) return false;
		}
		return true;
	}

//	@Test
//	public void testIsPrime(){
//		
//		assertTrue(isPrime(7));
//		
//	}
}
