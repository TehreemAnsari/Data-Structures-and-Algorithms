package ksmallest;

import java.io.IOException;
import java.util.Arrays;

public class MedianMethod {
	//Time taken ~85msec
	static int arr[];
	static int k=70;
	static int arrIndexSeen=0;
	static int median;
	static int ksmallest[]=new int[2*k];
	
	public static int[] readArray(int arrayLength, int k)
	{
		arr=new int[arrayLength];
		for(int i=0;i<arrayLength;i++)
		{
			arr[i]=(int) (Math.random()*arrayLength);
		}
		for(int i=0;i<2*k;i++)
		{
			ksmallest[i]=arr[i];
		}
		return arr;
	}
	public int findMedian(int[] ksmallest)
	{
		Arrays.sort(ksmallest);
		median=ksmallest[k];
		System.out.println("In findMedian::"+median);
		return median;
	}
	public int[] appendMore(int median)
	{
		System.out.println("allElems.length::"+arr.length);
		while(arrIndexSeen<arr.length)
		{	
			System.out.println("Elem seen::"+arrIndexSeen);
			int i=k;
			while(i<2*k && arrIndexSeen<=(arr.length-1))
			{
				System.out.println("Elements seen::"+(arrIndexSeen));
				if(arr[arrIndexSeen]<median)
				{
					System.out.println("Value of i::"+i);
					//System.out.println("Median::"+median);
					ksmallest[i]=arr[arrIndexSeen];
					i++;
				}
				arrIndexSeen++;
			}
			System.out.println("Value of i::"+i);
			if(i<=2*k)
			{
				System.out.println("In if(i<2*k)"+i);
				median=findMedian(ksmallest);
			}
		}
		return ksmallest;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime=System.currentTimeMillis();
		MedianMethod m= new MedianMethod();
		int totalElems=10000;
		//increase the value of totalElems and K for larger values
		arr=readArray(totalElems,k);
		median=m.findMedian(ksmallest);
		ksmallest=m.appendMore(median);
		for(int i=0;i<k;i++)
			System.out.print(ksmallest[i]+" ");
		long endTime=System.currentTimeMillis();
		System.out.println("\nTime taken:"+(endTime-startTime)+" msec");
	}
}
