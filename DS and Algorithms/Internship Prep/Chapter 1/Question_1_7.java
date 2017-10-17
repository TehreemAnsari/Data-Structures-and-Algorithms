package chap1;

import java.util.Scanner;

public class Question_1_7 {
	static int[][] arr;
	int[][] make2DArray(int sizeOfArray)
	{
		arr=new int[sizeOfArray][sizeOfArray];
		System.out.println("Enter Array");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<sizeOfArray;i++)
		{
			for(int j=0;j<sizeOfArray;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		sc.close();
		return arr;
	}
	void transpose(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr[0].length;j++)
			{
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
	}
	// An Inplace function to rotate a N x N matrix
	// by 90 degrees in anti-clockwise direction
	void rotateMatrix(int mat[][])
	{
		int N=mat.length;
	    // Consider all squares one by one
	    for (int x = 0; x < N / 2; x++)
	    {
	        // Consider elements in group of 4 in 
	        // current square
	        for (int y = x; y < N-x-1; y++)
	        {
	            // store current cell in temp variable
	            int temp = mat[x][y];
	 
	            // move values from right to top
	            mat[x][y] = mat[y][N-1-x];
	 
	            // move values from bottom to right
	            mat[y][N-1-x] = mat[N-1-x][N-1-y];
	 
	            // move values from left to bottom
	            mat[N-1-x][N-1-y] = mat[N-1-y][x];
	 
	            // assign temp to left
	            mat[N-1-y][x] = temp;
	        }
	    }
	}
	void printArray(int[][] array)
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[0].length;j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Question_1_7 obj=new Question_1_7();
		int a[][]=obj.make2DArray(3);
		System.out.println("Before");
		obj.printArray(a);
		obj.transpose(a);
		obj.printArray(a);
	}
}
