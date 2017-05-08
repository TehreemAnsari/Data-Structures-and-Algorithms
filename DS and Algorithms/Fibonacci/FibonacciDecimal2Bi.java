package fibonacci;

import java.io.IOException;

public class FibonacciDecimal2Bi {
	//Fibonacci%=35
	//Time taken:71 msec
	static int biArray[]=new int[1000000];
	public static int[] toBinary(int n)
	{
		int binary[]= new int[1000000];
		for(int i=binary.length-1;i>=0 && n>0;i--)
		{
			binary[i]=n%2;
			n=n/2;
		}	
		return binary;
	}
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
		biArray=toBinary(465421885);
		int A[][]={{1,1},{1,0}};
		int X[][]=power(A, biArray);
		System.out.println("Fibonacci%="+X[1][0]);
		long endTime=System.currentTimeMillis();
		System.out.println("Time taken:"+(endTime-startTime)+" msec");
	}
}
