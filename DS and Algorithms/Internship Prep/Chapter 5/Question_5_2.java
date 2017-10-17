package chap5;

import java.util.Scanner;

public class Question_5_2 {

	static double n;
	String convertFraction()
	{
		if(n>=1 || n<=0)
		{
			System.out.println("In (n>=1 || n<=0)");
			return "Error";
		}
		
		StringBuilder binary=new StringBuilder("0.");
		while(n>0)
		{
			if(binary.length()>=32)
				return "Error";
			double temp=n*2;
			if(temp>=1)
			{
				binary.append(1);
				n=temp-1;
			}
			else 
			{
				binary.append(0);
				n=temp;
			}
		}
		return binary.toString();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		n=sc.nextDouble();
		Question_5_2 obj=new Question_5_2();
		System.out.println(obj.convertFraction());
		sc.close();
	}
}
