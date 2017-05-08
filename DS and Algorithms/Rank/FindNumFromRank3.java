package findRank;

public class FindNumFromRank3 {
	public int partition(int[] array, int left, int right){
		int pivot = array[right]; 
	    while(true){
	        while(left <= right && array[left] <= pivot)
	            left++;

	        while(right >= left && array[right] > pivot)
	        right--;

	        if(left > right)
	        return left-1;	//current position of pivot element

	        int temp = array[left];
	        array[left] = array[right];
	        array[right] = temp;
	    }
	 }
	
	public int findRank(int array[], int rank, int left, int right)
	{
		int n= array.length;
		int pi=partition(array, left, right);	// index of pivot
		if(pi==n-rank)
			return array[pi];
		else if(pi<n-rank)
		{
			return findRank(array, rank, pi+1, right);
		}
		else if(pi>n-rank)
		{
			return findRank(array, rank, left, pi-1);
		}
		//return the kth rank element
		return array[pi];	
	}
	int kthSmallest(int arr[], int l, int r, int k)
	{
		// If k is smaller than number of elements in array
		if (k > 0 && k <= r - l + 1)
		{
			int pos = partition(arr, l, r);
			if (pos-l == k-1)
				return arr[pos];
			if (pos-l > k-1)
				return kthSmallest(arr, l, pos-1, k);

			return kthSmallest(arr, pos+1, r, k-pos+l-1);
		}
		return Integer.MAX_VALUE;
	}
	public static int[] readArray()
	{
		int[] arr=new int[1000000];
		for(int i=0;i<1000000;i++)
		{
			arr[i]=(int) (Math.random()*1000000);
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[]=readArray();
	    int n = arr.length;
	    int ks=3;
	    int rank=4;
		FindNumFromRank3 obj= new FindNumFromRank3();
		int elem=obj.findRank(arr, rank, 0, n-1);
		System.out.println("Element with rank "+rank+" is:"+elem);
		
		FindNumFromRank3 obj2= new FindNumFromRank3();
		int elem2=obj2.kthSmallest(arr, 0, n-1, ks);
		System.out.println("Element with "+ks+"th smallest value is:"+elem2);
	}
	
}

