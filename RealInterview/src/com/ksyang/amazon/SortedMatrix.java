package com.ksyang.amazon;

/*
 * Given an mXn Sorted matrix and a value X. 
 * Every row is sorted and first number of every row is greater 
 * than last number of previous row Find the value X in most efficient way.
 */
public class SortedMatrix {
	
	public static void main(String[] args){
		
		int[][] intMatrix= {{3, 6, 8},
						    {9, 15, 17},
						    {20, 31, 32},
						    {33, 34, 45}};
		
		int target = 33;
		
		int row = findRow(intMatrix, target);
		int collumn = findCollumn(intMatrix, target, row);

		System.out.println("("+row+","+collumn+")");
		
	}
	
	static int findRow(int[][] intMatrix, int target){
		int fRow =0;
		
		int rSize = intMatrix.length;
		int cSize = intMatrix[0].length;
		
		if(target<intMatrix[0][0]) return -1;
		if(target>intMatrix[rSize-1][cSize-1]) return -1;
		
		int tRow = 0;
		int bRow = rSize-1;
		boolean foundRow = false;
		while(!foundRow){
			
			if(target>=intMatrix[tRow][0] && target<=intMatrix[tRow][cSize-1]){
				foundRow = true;
				fRow = tRow;
				break;
			}
			if(target>=intMatrix[bRow][0] && target<=intMatrix[bRow][cSize-1]){
				foundRow = true;
				fRow = bRow;
				break;
			}
			
			int mRow = (tRow+bRow)/2;
			if(target<=intMatrix[mRow][cSize-1]){
				bRow = mRow;
			}else{
				tRow = mRow+1;
			}
		}
		
		return fRow;
	}

	static int findCollumn(int[][] intMatrix, int target, int row){
		int fCollumn=0;
		
		boolean found = false;
		int cSize = intMatrix[0].length;
		
		int left =0;
		int right = cSize-1;
		
		if(target<intMatrix[row][0] || target>intMatrix[row][cSize-1]) return -1;
		
		while(!found){
			
			if(target == intMatrix[row][left]){
				found = true;
				fCollumn = left;
				break;
			}else if(target == intMatrix[row][right]){
				found = true;
				fCollumn = right;
				break;
			}else{
				int middle = (left+right)/2;
				if(target<=intMatrix[row][middle]){
					right = middle;
				}else{
					left = middle+1;
				}
			}
			
			
		}
		return fCollumn;
	}
}
