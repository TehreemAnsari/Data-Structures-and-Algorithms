package basic;

public class MinHeap {

	void bottomUpHeapify(int a[])
	{
		int n=a.length;
		for(int i=n/2-1;i>=0;i--)
		{
			heapify(a, n, i);
		}
	}
	void sort(int a[])
	{
		for(int i=a.length-1;i>=0;i--)
		{
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			
			heapify(a, i, 0);
		}
	}
	void heapify(int a[], int n, int i)
	{
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n && a[largest]<a[l])
			largest=l;
		if(r<n && a[largest]<a[r])
			largest=r;
		if(largest !=i)
		{
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapify(a, n, largest);
		}
	}

	public static void main(String[] args) {
		int[] a= {7,9,11,2,6,5,8,3,1,0,4,10,15,12,13};
		MinHeap obj=new MinHeap();
		obj.bottomUpHeapify(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		obj.sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
