package basic;

import java.util.ArrayList;

public class PermutationsOfAString {
	//-----------------------code 1--------------------------------
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	        {
	        	System.out.println("Value of i="+i);
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	
	//-----------------------code 2--------------------------------	
	public static ArrayList<String> stringPermutations(String s) {
	    ArrayList<String> result = new ArrayList<String>();
	    stringPermutations("", s, result); 
	    return result;
	}
	 
	private static void stringPermutations(String prefix, String suffix, ArrayList results) {
	    if (suffix.length() == 0) {
	        results.add(prefix);
	    } else {
	        for (int i = 0; i < suffix.length(); i++) {
	            stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), results);
	        }
	    }
	}
	
	public static void main(String[] args) {
		//permutation("abc");
		ArrayList<String> arr=stringPermutations("abc");
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
	}
}
