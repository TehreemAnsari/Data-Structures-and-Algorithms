package chap1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Question_1_1 {
	static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String str=sc.nextLine();
		Question_1_1 obj= new Question_1_1();
		System.out.println(obj.isUnique(str));
	}
	boolean isUnique(String s)
	{
		System.out.println("isUnique() start");
		int count=0;
		HashSet<Character> set=new HashSet<>();
		char c[]=s.toCharArray();
		for(int i=0;i<c.length;i++)
		{
			set.add(c[i]);
		}
		System.out.println("After for");
	/*	Iterator<Character> itr=set.iterator();
		{
			while(itr.hasNext())
			{
				System.out.print(itr.next());
				count++;
			}
		}*/
		System.out.println("\nisUnique() end");
		if(set.size()==c.length)
		{
			return true;
		}
		else 
			return false;
	}
}
