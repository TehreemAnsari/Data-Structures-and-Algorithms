package heaps;

public class TestHeapSort {
	public static void main(String[] args) {
		long startTime=System.nanoTime();
		MinHeapSort h=new MinHeapSort();
		//h.makeHeap();//make heap working. This uses approx 1131079 nsec for 10 numbers
		h.makeHeapLinear();
		//bottomUpheap working
		h.printHeap();
		/*int min=h.deleteMin();//delete min working
		//topDownHeapify working
		System.out.println("Min="+min);
		h.printHeap();*/
		//h.addElem(3);//add new element to heap working
		//h.printHeap();
		//h.deleteAll();//delete all min and print heap in ascending order
		long endTime=System.nanoTime();
		System.out.println("Time taken:"+(endTime-startTime)+" nsec");
	}
}
