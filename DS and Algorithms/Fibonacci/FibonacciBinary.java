package fibonacci;

import java.io.IOException;
//Fibonacci of mod=67
//Time taken:130 msec
public class FibonacciBinary {
	static int n[]=new int[1000000];
	static int[][] power(int A[][], int n[])
	{
		int[][] Y={{1,0},{0,1}};
		int len=n.length-1;
		int i=len;
		while(i>=0)
		{
			if(n[i]==1)
			{	//if n is odd, do Y*A
				Y=CommonMethods.matrixMult(Y, A,75);
			}
			A=CommonMethods.matrixMult(A, A,75);
			i--;
		}
		return Y;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime=System.currentTimeMillis();
		n=(new CommonMethods().readBinaryArray(n));
		int A[][]={{1,1},{1,0}};
		int X[][]=power(A, n);
		System.out.println("Fibonacci%="+X[1][0]);
		long endTime=System.currentTimeMillis();
		System.out.println("Time taken:"+(endTime-startTime)+" msec");
	}
}
