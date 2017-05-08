package fibonacci;

import java.io.IOException;
//Fibonacci%=67
//Time taken:99140 msec
public class FibonacciDecimal {
	static int n[]=new int[100000];
	static int[][] power(int A[][], int n[])
	{
		int[][] Y={{1,0},{0,1}};
		int len=n.length-1;
		int i=0;
		while(i<=len)
		{
			if(n[len]%2==1)
			{	//if n is odd, do Y*A
				Y=CommonMethods.matrixMult(Y, A,75);
			}
			A=CommonMethods.matrixMult(A, A,75);
			//divide n by 2.
			n=CommonMethods.divideBy2(n);
			if(n[i]==0)
			{
				i++;
			}
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
