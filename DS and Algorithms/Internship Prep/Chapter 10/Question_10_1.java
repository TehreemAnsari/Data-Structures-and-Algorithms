package chap10;

public class Question_10_1 {
	static int a[], b[];
	
	
	void mergeFromLargest(int a[],int b[], int lastA, int lastB)
	{
		int indexA=lastA-1;
		int indexB=lastB-1;
		int indexMerged=lastA+lastB-1;
		
		while(indexB>=0)
		{
			if(indexA>=0 && a[indexA]>b[indexB])
			{
				a[indexMerged]=a[indexA];
				indexA--;
				indexMerged--;
			}
			else
			{
				a[indexMerged]=b[indexB];
				indexB--;
				indexMerged--;
			}
		}
	}
	public static void main(String[] args) {
		a=new int[10];
		b=new int[4];

		a[0]=2;
		a[1]=4;
		a[2]=5;
		a[3]=7;
		a[4]=9;
		a[5]=11;
		
		b[0]=1;
		b[1]=3;
		b[2]=5;
		b[3]=8;
		
		Question_10_1 obj=new Question_10_1();
		obj.mergeFromLargest(a, b, 6, 4);
		System.out.println("Merged array is");
		for(int i:a)
		{
			System.out.print(i+" ");
		}
	}
}
