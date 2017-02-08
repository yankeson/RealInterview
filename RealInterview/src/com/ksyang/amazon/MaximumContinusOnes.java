package com.ksyang.amazon;

public class MaximumContinusOnes {
	
	public static void main(String[] args){
		
		String onesAndZeros = "11000111111010000111000";
		
		int max = 0;
		int l = onesAndZeros.length();
		int lengthOfOnes = 0;
		
		for(int i=0; i<l; i++){
			
			if(onesAndZeros.charAt(i) == '1'){
				
				lengthOfOnes++;
				if(lengthOfOnes>max) max=lengthOfOnes;
			}else{
				
				lengthOfOnes=0;
				
			}
			
		}
		
		System.out.println(max);
	}

}
