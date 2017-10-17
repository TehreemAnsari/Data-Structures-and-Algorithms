package chap1;

import java.util.Scanner;

public class Question_1_5 {
	static char[] c1;
	static char[] c2;
	static String s1;
	static String s2;
	void getStrings()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st string");
		s1=sc.nextLine();
		System.out.println("Enter 2ns string");
		s2=sc.nextLine();
	}
	boolean isOneEditAway(String s1, String s2)
	{
		c1=s1.toCharArray();
		c2=s2.toCharArray();
		if(Math.abs(c1.length-c2.length)>1)
		{
			return false;
		}
		int editDist=0;
		for(int i=0,j=0;i<c1.length && j<c2.length ; )
		{
			if(c1[i]!=c2[j])
			{
				editDist++;
				if(editDist>1)
				{
					System.out.println("False");
					return false;
				}
					
				if(c1.length>c2.length)	//c1 is bigger string
				{
					i++;
				}
				else if(c2.length>c1.length)					//c2 is bigger string
				{
					j++;
				}
				else
				{
					i++;
					j++;
				}
			}
			else
			{
				i++;
				j++;
			}
		}
		System.out.println("True");
		return true;
	}
	public static void main(String[] args) {
		Question_1_5 obj=new Question_1_5();
		obj.getStrings();
		obj.isOneEditAway(s1, s2);
	}
}
