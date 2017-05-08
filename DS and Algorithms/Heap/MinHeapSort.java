package heaps;
//min heap
public class MinHeapSort {
	int heap[]=new int [100000000];
	static int heapSize=10;
	public int[] bottomUpHeapify(int i)
	{
		while(i>0 && heap[(i-1)/2]>heap[i])
		{
			int temp=heap[(i-1)/2];
			heap[(i-1)/2]=heap[i];
			heap[i]=temp;
			i=(i-1)/2;
		}
		return heap;
	}
	public int[] topDownHeapify(int i)
	{
		int l,r,m,n=heapSize;
		while((2*i+1)<n)
		{
			l=2*i+1;
			r=2*i+2;
			if(r<n && heap[r]<heap[l])
			{
				m=r;
			}
			else
				m=l;
			if(heap[i]>heap[m])
			{
				int temp=heap[i];
				heap[i]=heap[m];
				heap[m]=temp;
				i=m;
			}
			else
				break;
		}
		return heap;
	}
	public void makeHeap()
	{
		//this takes O(n log n)
		for(int i=0;i<heapSize;i++)
			heap[i]=(int)(Math.random()*100);
		for(int i=1;i<heapSize;i++)
			heap=bottomUpHeapify(i);
	}
	public void makeHeapLinear()
	{
		for(int i=0;i<heapSize;i++)
			heap[i]=(int)(Math.random()*100);
		for(int i=heapSize/2;i>=0;i--)
			heap=topDownHeapify(i);
	}
	public void addElem(int element) {
		if(heapSize<heap.length)
			heap[heapSize]=element;
		heap=bottomUpHeapify((heapSize));
		heapSize++;
	}
	public int deleteMin()
	{
		if(heapSize>0)
		{
			int temp=heap[0];
			heap[0]=heap[heapSize-1];
			heap[heapSize-1]=temp;
			heapSize--;
			heap=topDownHeapify(0);
			return temp;
		}
		return 0;
	}
	public void deleteAll()
	{
		while(heapSize>0)
			System.out.print(deleteMin()+" ");
	}
	public void printHeap()
	{
		for(int i=0;i<heapSize;i++)
			System.out.print(heap[i]+" ");
		System.out.println();
	}
}
