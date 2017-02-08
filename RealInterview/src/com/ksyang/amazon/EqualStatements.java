package com.ksyang.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*If you were given a series of equations e.g. [A = B, B = D, C = D, F = G, 
 * E = H, H = C] 
and then another series [A != C, D != H, ..., F != A ] 

Check whether the equations combined is valid. 

For the example given, your program should return 'invalid', because 
the first series implies that A = C, which contradicts the statement A != C 
in the second series.
*/
public class EqualStatements {
	
	public static void main(String[] args){
		
		String[][] equals = {{"A", "B"}, {"B", "D"}, {"C","D"}, {"F", "G"}, {"E","H"}, {"H","C"}};
		String[][] unequals = {{"A","C"}, {"D","H"}, {"F","A"}};
		
		Map<String, Set<String>> equalsMap = createEaualsMap(equals);
		
		System.out.println(validateEqualStatements(equalsMap, unequals));
	}
	
	//O(n) n: number of equal statements.
	public static Map<String, Set<String>> createEaualsMap(String[][] equals){
		
		Map<String, Set<String>> equalsMap = new HashMap<>();
		
		for(int i=0; i<equals.length; i++){
			
			String s1 = equals[i][0];
			String s2 = equals[i][1];
			
			Set<String> set1 = equalsMap.get(s1);
			Set<String> set2 = equalsMap.get(s2);
			
			if(set1 == null){
				set1 = new HashSet<>();
				equalsMap.put(s1, set1);
			}
			set1.add(s2);
			
			if(set2 == null){
				set2 = new HashSet<>();
				equalsMap.put(s2, set2);
			}
			set2.add(s1);
		}
		
		return equalsMap;
	}
	
	//O(m) m: number of unequal statements
	public static boolean validateEqualStatements(Map<String, Set<String>> equalsMap, String[][] unequals){
		
		for(int i=0; i<unequals.length; i++){
			
			String s1 = unequals[i][0];
			String s2 = unequals[i][1];
			
			Set<String> set1 = equalsMap.get(s1);
			if(set1.contains(s2)) return false;
			
			Set<String> set2 = equalsMap.get(s2);
			if(set2.contains(s1)) return false;
			
			Set<String> visited1 = new HashSet<>();
			visited1.add(s1);
			if(!validate(equalsMap, visited1, set1, s2)) return false;
			
			Set<String> visited2 = new HashSet<>();
			visited2.add(s2);
			if(!validate(equalsMap, visited2, set2, s1)) return false;

		}
		
		return true;
	}
	
	public static boolean validate(Map<String, Set<String>> equalsMap, Set<String> visited, Set<String> equalSet, String unequal){
		
		Iterator<String> itr = equalSet.iterator();
		while(itr.hasNext()){
			
			String s = itr.next();
			if(!visited.contains(s)){
				
				Set<String> cSet = equalsMap.get(s);
				if(cSet.contains(unequal)) return false;
				
				visited.add(s);
				return validate(equalsMap, visited, cSet, unequal);
			}	
		}
		
		return true;
	}
}
