package fibonacci;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateArray {
	static int[] arr=new int[1000000];
	public static void readArray()
	{
		for(int i=0;i<1000000;i++)
		{
			arr[i]=(int)(Math.random()*10);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		readArray();
		PrintWriter pWriter = new PrintWriter("array.txt");
		for (int i : arr) {
			pWriter.println(i);
		}
		pWriter.close();
	}
}
