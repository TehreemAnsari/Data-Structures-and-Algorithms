package heaps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxHeapSort {
	static int heapSize=1000;
	int allElements[]=new int [10000000];
	int heap[]=new int [1000];	//put heapsize here
	public int[] bottomUpHeapify(int i)
	{
		while(i>0 && heap[(i-1)/2]<heap[i])
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
			if(r<n && heap[r]>heap[l])
			{
				m=r;
			}
			else
				m=l;
			if(heap[i]<heap[m])
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
	public int[] kSmallestElems()
	{
		int j=heapSize;
		//j tracks indexes of all elem
		while(j<allElements.length)
		{
			if(allElements[j]<heap[0])
			{
				deleteMax();
				System.out.print(" Should add elem"+allElements[j]);
				addElem(allElements[j]);
			}
			j++;
		}
		System.out.println("J =="+j);
		return heap;
	}
	public void makeHeap() throws NumberFormatException, IOException
	{
		//this takes O(n log n)
		FileReader fr=new FileReader("heapNumbers.txt");
	    BufferedReader br=new BufferedReader(fr);
	    for(int i=0;i<10000000;i++){
	        allElements[i]=Integer.parseInt(br.readLine());
	    }
	    for(int i=0;i<heapSize;i++){
	        heap[i]=allElements[i];
	    }
	    br.close();
		for(int i=1;i<heapSize;i++)
			heap=bottomUpHeapify(i);
	}
	public void addElem(int element) {
		if(heapSize<heap.length)
			heap[heapSize]=element;
		heap=bottomUpHeapify((heapSize));
		heapSize++;
	}
	public int deleteMax()
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
	public void printHeap()
	{
		for(int i=0;i<heapSize;i++)
			System.out.print(heap[i]+" ");
		System.out.println();
	}
	public void deleteAll()
	{
		while(heapSize>0)
			System.out.print(deleteMax()+" ");
	}
}
