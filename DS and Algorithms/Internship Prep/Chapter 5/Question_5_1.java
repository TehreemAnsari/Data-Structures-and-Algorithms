package chap5;

import java.util.Scanner;

public class Question_5_1 {
	static int n,m, mask, i, j;
	int createMask(int n,int j, int i)
	{
		int left=~0;
		left=left<<(j+1);
		
		int right=~0;
		right=(1<<i)-1;
		
		int mask=left|right;
		return mask;
	}
	int clearN(int n,int mask)
	{
		n=n&mask;
		return n;
	}
	int mergeNM(int n,int m)
	{
		m=m<<i;		//move m to i
		return n|m;
	}
	public static void main(String[] args) {
		Question_5_1 obj=new Question_5_1();
		System.out.println(~0);	//~0 is all ones, since it is in 2's compliment
		System.out.println(obj.createMask(1, 2, 2));
		System.out.println(Integer.toBinaryString(2));
		//System.out.println(Integer.parseInt("3", 2));
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N in binary");
		String n1=sc.nextLine();
		n=Integer.parseInt(n1, 2);
		System.out.println("Enter M in binary");
		String m1=sc.nextLine();
		m=Integer.parseInt(m1, 2);
		System.out.println("Enter i and j");
		i=sc.nextInt();
		j=sc.nextInt();
		mask=obj.createMask(n, j, i);
		n=obj.clearN(n, mask);
		n=obj.mergeNM(n, m);
		System.out.println("New N="+Integer.toBinaryString(n));
		sc.close();
	}
}
