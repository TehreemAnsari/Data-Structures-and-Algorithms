package chap1;

import java.util.Arrays;
import java.util.Scanner;

public class Question_1_2 {
	static int[] a;
	static char[] c1;
	static char[] c2;
	static String s1;
	static String s2;
	void getStrings()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st string");
		s1=sc.nextLine();
		c1=s1.toCharArray();
		System.out.println("Enter 2ns string");
		s2=sc.nextLine();
		c2=s2.toCharArray();
		a= new int[c1.length];
		for(int i=0;i<a.length;i++)
		{
			a[i]=0;
			System.out.print(a[i]);
		}
	}
	
	/*boolean checkString(char c1[], char c2[], int a[])
	{
		int j=0,k=0, count=0;
		System.out.println("Start checkString()");
		while(j<c1.length && a[j]==0)
		{
			System.out.println("In While 1 j="+j);
			while(k<c2.length)
			{
				System.out.println("In while 2 k="+k);
				if(c1[j]==c2[k]&&a[k]==0)
				{
					a[j]=1;
					System.out.println("In if block Value of k="+k);
					k++;
					break;
				}
				k++;
				System.out.println("Value of k="+k);
			}
			k=0;
			j++;
			System.out.println("Value of j="+j);
			System.out.println("Value of a["+(j-1)+"] set to::"+a[j-1]);
		}
		for(int t=0;t<a.length;t++)
		{
			System.out.print(a[t]);
			if(a[t]==1)
			{
				count++;
			}
		}
		if(count==a.length)
		{
			System.out.println("Permutation");
			return true;
		}
		System.out.println("Not Permutation");
		return false;
	}*/
	public boolean checkAnagram(String str1, String str2) {

	    if (str1.length() != str2.length())
	      return false;

	    char[] a = str1.toCharArray();
	    char[] b = str2.toCharArray();

	    Arrays.sort(a);
	    Arrays.sort(b);

	    return Arrays.equals(a, b);
	}
	public static void main(String[] args) {
		Question_1_2 obj=new Question_1_2();
		obj.getStrings();
		obj.checkAnagram(s1, s2);
	}
}
