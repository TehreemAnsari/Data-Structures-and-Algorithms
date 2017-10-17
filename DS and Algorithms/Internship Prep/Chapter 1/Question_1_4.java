package chap1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Question_1_4 {

	static char[] c1;
	static char[] c2;
	static String s1;
	static String s2;
	static HashMap<Character, Integer> m;
	void getStrings()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string");
		s1=sc.nextLine();
		c1=s1.toCharArray();
	}
	HashMap<Character, Integer> makeMap(char c[])
	{
		m=new HashMap<>();
		for(int i=0;i<c.length;i++)
		{
			if(m.containsKey(c[i]))
			{
				int temp=m.get(c[i]).intValue();
				temp=temp+1;
				m.put(c[i],temp);
			}
			else
				m.put(c[i], 1);
		}
		for(Map.Entry<Character, Integer> entry: m.entrySet())
		{
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		return m;
	}
	boolean checkPermPalindrom(Map<Character, Integer> m)
	{
		boolean flag=true;
		int numberOfOdd=0;
		Set<Character> keySet=m.keySet();
		Iterator<Character> itr=keySet.iterator();
		while(itr.hasNext())
		{
			char currKey=itr.next();
			if(m.get(currKey).intValue() % 2 !=0)
			{
				numberOfOdd++;
			}
		}
		if(numberOfOdd<=1)
		{
			System.out.println("Permutation");
			return true;
		}
		System.out.println("Not Permutation");
		return false;
	}
	public static void main(String[] args) {
		Question_1_4 obj= new Question_1_4();
		obj.getStrings();
		obj.makeMap(c1);
		obj.checkPermPalindrom(m);
	}
}
