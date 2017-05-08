package fibonacci;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommonMethods {
	public int[] readArray(int n[]) throws NumberFormatException, IOException
	{
		FileReader fr=new FileReader("array.txt");
	    BufferedReader br=new BufferedReader(fr);
	    for(int i=0;i<n.length;i++){
	        n[i]=Integer.parseInt(br.readLine());
	    }
	    br.close();
	    /*for(int i=0;i<1000000;i++)
		{
			n[i]=(int)(Math.random()*10);	
			//we can directly create an array too
			//instead of reading it from a file
		}*/
		return n;   
	}
	public int[] readBinaryArray(int n[]){
		for(int i=0;i<1000000;i++)
		{
			n[i]=(int)(Math.random()*10);	
			if(n[i]<5)
				n[i]=0;
			else
				n[i]=1;
			//we can directly create an array too
			//instead of reading it from a file
		}
		return n;
	}
	public static int[][] matrixMult(int F[][], int M[][],int m)
	{
		int Y[][]=new int[2][2];
		Y[0][0] =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
		Y[0][1] =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
		Y[1][0] =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
		Y[1][1] =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
				Y[i][j]=Y[i][j]%m;
		}
	  return Y;
	}
	public static int[] divideBy2(int[] n)
	{
		int last=n.length-1;
		int remainder=0;
		int present=0;
		int j=0;
		for(int i=0;i<=last;i++)
		{
		    present=remainder*10+n[i];
		    remainder=present%2;
		    n[i]=present/2;
		    //System.out.println("In DivideBy2:"+n[i]);
		    if(n[j]==0)
		    {//ie nothing more left to divide, so go to the next right digit by incr j
		    	j++;
		    }
		}
		return n;
	}
}
