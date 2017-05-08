package fibonacci;

import java.io.IOException;
//Fibonacci%=67
//Time taken:349 msec
public class FibonacciDecimal2 {
	static int n[]=new int[100000];
	static int[][] power(int A[][], int n[])
	{
		int[][] Y={{1,0},{0,1}};
		int len=n.length-1;
		int i=len;
		while(i>=0)
		{
			int[][] Z={{1,0},{0,1}};
			for(int b=0;b<n[i];b++)
			{
				Z=CommonMethods.matrixMult(Z, A, 75);
			}
			Y=CommonMethods.matrixMult(Y, Z, 75);
			int[][] d={{1,0},{0,1}};
			for(int h=0;h<10;h++)
			{
			    d=CommonMethods.matrixMult(d,A,75);//multiply by 10
			}
			A=d;
			i--;//divide by 10
		}
		return Y;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime=System.currentTimeMillis();
		n=(new CommonMethods().readArray(n));
		int A[][]={{1,1},{1,0}};
		int X[][]=power(A, n);
		System.out.println("Fibonacci%="+X[1][0]);
		long endTime=System.currentTimeMillis();
		System.out.println("Time taken:"+(endTime-startTime)+" msec");
	}
}
