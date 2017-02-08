package com.ksyang.amazon;

import java.util.Stack;

/*
 * How to verify the string which contains alpha-bates,parenthesis and 
 * signglle/double quote 
 * Ex: AB(CD{"GH"}) is valid 
 * "A()B' is invalid
 * 
 * ask: do we need verify the child string enclosed inside quotes?
 */
public class ParenthesisAndQuotesVerifier {

	public static void main(String[] args){
		
		String s1 = "AB(CD{\"GH\"})";
		String s2 = "\"A()B'";
		
		System.out.println(verify(s1));
		System.out.println(verify(s2));
		
	}
	
	public static boolean verify(String s){
		
		Stack<String> stack = new Stack<String>();
		String pStr = null;
		
		for(int i=0; i<s.length(); i++){
			String str = s.charAt(i)+"";
			
			if(stack.isEmpty()){
				pStr = "";
			}else{
				pStr = stack.peek();
			}
			
			switch(str){
			
				case "{":
					stack.add(str);
					break;
				case "(":
					stack.add(str);
					break;
				case "}":
					if(! pStr.equals("{")) return false;
					stack.pop();	
					break;
				case ")":	
					if(! pStr.equals("(")) return false;
					stack.pop();	
					break;
				case "\"":
					if(pStr.equals("\"")){
						stack.pop();
					}else{
						stack.add(str);
					}
					break;
				case "'":
					if(pStr.equals("'")){
						stack.pop();
					}else{
						stack.add(str);
					}
					break;
			}
		}
	
		if(stack.isEmpty()) return true;
		
		return false;
	}
}
