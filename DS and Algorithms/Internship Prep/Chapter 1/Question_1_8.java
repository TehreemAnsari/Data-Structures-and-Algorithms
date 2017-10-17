package chap1;
import java.util.*;

public class Question_1_8 {
	
	/*Use one boolean variate(isZeroInFirstRow) saving if first row has zero element(s) or not 
	 * and one boolean variate(isZeroInFirstCol) saving if first column has zero element(s) or not.
	Then, traverse the whole matrix. If cell(i,j)==0, then set cell(0,j) and cell(i,0) to 0.
	Traverse the first row of the matrix. If cell(0,j)==0, then set all elements in column(j) to 0.
	Traverse the first column of the matrix. If cell(i,0)==0, then set all elements in row(i) to 0.
	If isZeroInFirstRow==true, set all elements in row(0) to 0.
	If isZeroInFirstCol==true, set all elements in column(0) to 0.*/
	
	static int[][] arr;
	int sizeOfArray=3;
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
	void makeZero1(int[][] a,int sizeOfArry)
	{
		boolean[] rows=new boolean[sizeOfArry];
		boolean[] cols=new boolean[sizeOfArry];
		for(int i=0;i<sizeOfArry;i++)
		{
			for(int j=0;j<sizeOfArry;j++)
			{
				if(a[i][j]==0)
				{
					rows[i]=true;
					cols[j]=true;
				}
			}
		}
		
		for(int i=0;i<sizeOfArry;i++)
		{
			for(int j=0;j<sizeOfArry;j++)
			{
				if(rows[i]||cols[j])
					arr[i][j]=0;
			}
		}
	}
	/*public static void setZero(int M[][]){
		boolean rows [] = new boolean[M.length];
		System.out.println("M.length::"+M.length);
		boolean columns[] = new boolean[M[0].length];
		System.out.println("M[0].length"+M[0].length);
		
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[i].length; j++){
				if(M[i][j] == 0 ){
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[i].length ; j++){
				if(rows[i] || columns[j]){
					M[i][j] = 0;
				}
			}
		}
	}*/
	
	
	//This is the better method
	public static void nullify(int[][] arr){
		if (arr==null){return;}
		
		boolean nullifyFirstRow = false;
		boolean nullifyFirstColumn = false;
		
		for (int i=0;i<arr.length;i++){
			if (arr[i]==null){return;}
			for (int j=0;j<arr[i].length;j++){
				if (arr[i][j]==0){
					arr[i][0]=0;arr[0][j]=0;
					if (i==0){nullifyFirstRow=true;}
					if (j==0){nullifyFirstColumn=true;}
				}
			}
		}
		
		for (int i=1;i<arr.length;i++){
			for (int j=1;j<arr[i].length;j++){
				arr[i][j] = ((arr[i][0]==0) || (arr[0][j]==0)) ? 0 : arr[i][j];
			}
		}
		
		for (int i=0;i<arr.length;i++){arr[i][0] = (nullifyFirstColumn) ? 0 : arr[i][0];}
		for (int j=0;j<arr[0].length;j++){arr[0][j] = (nullifyFirstRow) ? 0 : arr[0][j];}
	}
	
	void printArray(int[][] array, int rows, int cols)
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Question_1_8 obj=new Question_1_8();
		obj.make2DArray(3);
		obj.makeZero1(arr, 3);
		//setZero(arr);
		obj.printArray(arr, 3, 3);
	}
}
