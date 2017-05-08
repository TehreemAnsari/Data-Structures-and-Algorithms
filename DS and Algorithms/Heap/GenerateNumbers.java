package heaps;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenerateNumbers {
	static int[] arr=new int[10000000];
	public static void readArray()
	{
		for(int i=0;i<10000000;i++)
		{
			arr[i]=(int)(Math.random()*10000);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		readArray();
		PrintWriter pWriter = new PrintWriter("heapNumbers.txt");
		for (int i : arr) {
			pWriter.println(i);
		}
		pWriter.close();
	}
}
