package heaps;

import java.io.IOException;

public class HeapAlgo1 {
	//Time taken:1339 msec
	static int k=10000;
	int heap[]=new int [k];
	static int heapSize=k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime=System.currentTimeMillis();
		MaxHeapSort h= new MaxHeapSort();
		h.makeHeap();
		h.kSmallestElems();
		h.printHeap();
		long endTime=System.currentTimeMillis();
		System.out.println("\nTime taken:"+(endTime-startTime)+" msec");
	}
}
