package basic;
import java.util.*;
public class PermutationOfIntegers {
	public static List<int[]> listPermutations(int[] a) {
	    ArrayList<int[]> results= new ArrayList<int[]>();
	    listPermutations(a, 0, results);
	    return results;
	}
	 
	private static void listPermutations(int[] a, int start, List<int[]> result) {
	    if (start >= a.length) {
	        result.add(a.clone());
	    } else {
	        for (int i = start; i < a.length; i++) {
	            swap(a, start, i);
	            listPermutations(a, start+1, result);
	            swap(a, start, i);
	        }
	    } 
	}
	 
	private static void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	public static void main(String[] args) {
		int a[]={1,2,3};
		ArrayList<int[]> arr=(ArrayList<int[]>) listPermutations(a);
		for (int[] temp:arr)
		{
			for(int i:temp)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
