package com.ksyang.amazon;

public class MergeSortedArrays {
	
	public static void main(String[] args){
		
		int[] nArr1 = {7, 9, 10, 15, 20, 21};
		int[] nArr2 = {3, 6, 8, 8, 10, 19, 23};
	
		int idx1=0;
		int idx2=0;
		
		int l1 = nArr1.length;
		int l2 = nArr2.length;
		
		int l = l1+l2;
		int[] nArr = new int[l];
		int idx=0;
		
		while(idx < l){
			
			if(idx1<l1 && idx2<l2){
				if(nArr1[idx1]<=nArr2[idx2]){
					nArr[idx] = nArr1[idx1];
					idx1++;
				}else{
					nArr[idx] = nArr2[idx2];
					idx2++;
				}
			}else if(idx1<l1){
				nArr[idx] = nArr1[idx1];
				idx1++;
			}else if(idx2<l2){
				nArr[idx] = nArr2[idx2];
				idx2++;
			}
			idx++;
		}
		
		for(int i=0; i<l; i++){
			System.out.print(nArr[i]+" ");
		}
	}

}
