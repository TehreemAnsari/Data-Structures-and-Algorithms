package heaps;

import java.io.IOException;

public class TestMaxHeapSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime=System.nanoTime();
		MaxHeapSort h=new MaxHeapSort();
		h.makeHeap();	//working
		//h.makeHeapLinear();
		//bottomUpheap working
		h.printHeap();
		int max=h.deleteMax();
		//topDownHeapify working
		System.out.println("Max="+max);
		h.printHeap();
		h.addElem(93);//add new element to heap working
		h.printHeap();
		h.deleteAll();//delete all min and print heap in ascending order
		long endTime=System.nanoTime();
		System.out.println("Time taken:"+(endTime-startTime)+" nsec");
	}
}
