package com.ksyang.amazon;

/*
 * Consider the following series: 

A := 1 
B := A*2 + 2 
C := B*2 + 3 and so on... 
Write a program that: 

-outputs the number corresponding to a given letter; 

-given a string of letters like 'GREP', computes the sum of the numbers corresponding to all the letters in the string (i.e., G + R + E + P), as given by the above series; and 

-given a large number (that would fit into a standard 32-bit integer), 
finds the shortest string of letters corresponding to it. You may use a 
greedy approach for the last part. Compute the values of the numbers 
corresponding to letters as and when required and DO NOT pre-compute 
beforehand and store them in a data structure.
 */
public class ComputeSum {
	
	public static void main(String[] args){
		
		ComputeSum cs = new ComputeSum();
		int[] series = new int[26];
		series[0] = 1;
		
		cs.generateSeries(series);
		
		for(int i=0; i<26; i++){
			System.out.print(series[i]+" ");
		}
		
		System.out.println();
		
		int res = cs.sum("ABC", series);
		
		
		System.out.println(res);
		
		cs.generateShortestString(100, series);
	}
	
	public void generateSeries(int[] series){
		
		for(int i=1; i<26; i++){
			series[i] = series[i-1]*2+(i+1);
		}
		
	}
	
	public int sum(String str, int[] series){
		
		int res = 0;
		
		for(int i=0; i<str.length(); i++){
			int idx = str.charAt(i)-65;
			res = res+series[idx];
		}
		return res;
	}
	
	public String generateShortestString(int input, int[] series){
		
		int remain = input;
		
		for(int i=25; i>=0; i--){
			
			if(remain<series[i]) continue;
			
			int n = remain/series[i];
			System.out.println("("+i+","+n+")");
			remain = remain%series[i];
		}
		return null;
	}

}
