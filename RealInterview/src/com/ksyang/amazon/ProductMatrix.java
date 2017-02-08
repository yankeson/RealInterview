package com.ksyang.amazon;

/*
 * You are given an array of integers(with all valid input) You have to 
 * write a function which will produce another array, where the value 
 * in each index of the array will be the product of all values 
 * in the given array except that index. 

Example 
Array 1: 1 2 3 4 5 
Array 2: 120 60 40 30 24. 
Come up with a solution of O(n^2) can you improve it?
 */
public class ProductMatrix {
	
	public static void main(String[] args){
		
		int[] initArr = {1, 2, 3, 4, 5};
		int[] productArr = new int[initArr.length];
		
		int totalProduct = 1;
		for(int i=0; i<initArr.length; i++){
			totalProduct = totalProduct*initArr[i];
		}
		
		for(int i=0; i<productArr.length; i++){
			productArr[i] = totalProduct/initArr[i];
			System.out.print(productArr[i]+" ");
		}
		System.out.println();
	}

}
