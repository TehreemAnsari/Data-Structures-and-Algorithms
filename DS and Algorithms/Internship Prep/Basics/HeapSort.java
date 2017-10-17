package basic;

public class HeapSort
{
	public void sort(int arr[])
	{
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

	}

	void heapify(int arr[], int n, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2*i + 1; // left = 2*i + 1
		int r = 2*i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i)
		{
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}


	// Driver program
	public static void main(String args[])
	{
		int arr[] = {7,9,11,2,6,5,8,3,1,0,4,10,15,12,13};

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
