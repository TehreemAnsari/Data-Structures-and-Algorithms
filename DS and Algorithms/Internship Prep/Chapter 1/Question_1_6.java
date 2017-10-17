package chap1;

import java.util.Scanner;

public class Question_1_6 {
	static char[] c;
	static String s1;
	void getStrings()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string");
		s1=sc.nextLine();
	}
	StringBuilder compressString(String s)
	{
		c=s.toCharArray();
		int count=1;
		char last=c[0];
		StringBuilder compress=new StringBuilder();
		for(int i=1;i<c.length;i++)
		{
			if( c[i]==last)
			{
				count++;
			}
			else
			{
				compress.append(""+last+count);
				count=1;
			}
			last=c[i];
		}
		compress.append(""+last+count);
		return compress;
	}
	public static void main(String[] args) {
		Question_1_6 obj=new Question_1_6();
		obj.getStrings();
		System.out.println(obj.compressString(s1));
	}
}
