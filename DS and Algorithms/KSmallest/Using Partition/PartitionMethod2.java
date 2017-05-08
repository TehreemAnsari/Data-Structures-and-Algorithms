package ksmallest;

import java.util.Random;

public class PartitionMethod2 {
	//Time taken: 16msec
	static int[] arr;
	static int k,arrIndexSeen, partitionIndex;
	static int[] kArray;
	public static int pivot(int[] ar,int l,int r)
	 {
	 	Random rand=new Random();
	 	int x=rand.nextInt(r-l); //finds a random number btn 0 and r-l, excluding r-l including 0
	 	return(x);
	 }
	public static int partition(int[] array, int left, int right, int index){
		int pivotElem = array[index];	//consider 1st elem as pivot elem 
	    while(true){
	        while(left <= right && array[left] <= pivotElem)
	            left++;

	        while(right >= left && array[right] > pivotElem)
	        right--;

	        if(left > right)
	        return left-1;	//current position of pivot element

	        int temp = array[left];
	        array[left] = array[right];
	        array[right] = temp;
	    }
	}
	public static int[] readArray(int arrayLength)
	{
		arr=new int[arrayLength];
		for(int i=0;i<arrayLength;i++)
		{
			arr[i]=(int) (Math.random()*arrayLength);
		}
		return arr;
	}
	public static int[] getKArray(int kIndex)
	{
		for(int i=kIndex; i<2*k && arrIndexSeen<arr.length;i++, arrIndexSeen++)
		{
			kArray[i]=arr[arrIndexSeen];
		}
		arrIndexSeen--;
		System.out.println("Index seen="+arrIndexSeen);
		return kArray;
	}
	public static void ksmallest()
	{
		while(arrIndexSeen+1<arr.length)
		{
			int pivotIndex=pivot(kArray, 0, kArray.length);
			partitionIndex=partition(kArray, 0, 2*k-1, pivotIndex);
			if(partitionIndex>k)
				kArray=getKArray(partitionIndex);
		}
		System.out.println("K smallest elems are:");
		printArray(kArray, k);
		return;
	}
	public static void printArray(int[] array, int till)
	{
		for(int i=0;i<till;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		arr= readArray(200); 
		printArray(arr, arr.length);
		arrIndexSeen=0;
		k=70;
		kArray= new int[2*k];
		kArray=getKArray(0);
		printArray(kArray, kArray.length);
		ksmallest();
		long endTime=System.currentTimeMillis();
		System.out.println("\nTime taken:"+(endTime-startTime)+" msec");
	}
}
