package com.ksyang.amazon;

import java.util.Stack;

/*
 *remove 3 consecutive duplicates form a string
 *i/p : aabbbaccddddc
 *o/p : ccdc
 */
public class RemoveTripleConsecutiveDuplicates {
	
	public static void main(String[] args){
		
		String iStr= "aabbbaccddddc";
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<iStr.length(); i++){
			
			Character c2 = null;
			Character c1 = null;
			if(!stack.isEmpty()){
				c2 = stack.pop();
			}
			if(!stack.isEmpty()){
				c1 = stack.pop();
			}
			
			Character c3 = iStr.charAt(i);
			
			if(c2==null){
				stack.add(c3);
			}else if(c1 == null){
				stack.add(c2);
				stack.add(c3);
			}else{
				
				if(c1.equals(c2) && c1.equals(c3)){
					continue;
				}else{
					stack.add(c1);
					stack.add(c2);
					stack.add(c3);
				}
				
			}
		}
		
		String oStr="";
		while(!stack.isEmpty()){
			oStr = stack.pop()+oStr;
		}
		
		System.out.println(oStr);
	}

}
