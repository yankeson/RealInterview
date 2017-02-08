package com.ksyang.amazon;

/*
 * Given an array , find the element (say X) that has all the elements less that 
 * it to its left side and all the elements greater to it on its right side. 
 * The left and right elements of X need not be in sorted form.
 */
public class FindX {
	
	public static void main(String[] args){
		
		int[] numbers = {5,4,3,7,4,1,2,8,10};
		
		int leftMax  = Integer.MIN_VALUE;
		
		for(int i=0; i<numbers.length; i++){
			boolean isX = true;
			
			if(numbers[i]<leftMax) continue;
			leftMax = numbers[i];
			
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[j]<numbers[i]){
					isX = false;
					break;
				}
			}
			
			if(isX){
				System.out.println(numbers[i]);
				break;
			}else{
				continue;
			}
		}
		
		
	}

}
