package findRank;

import java.util.Arrays;

public class FindRankDeter{
	public int partition(int[] array, int left, int right){
		int pivot = goodpivot1(array, left, right); 
	    while(true){
	        while(left <= right && array[left] <= pivot)
	            left++;

	        while(right >= left && array[right] > pivot)
	        right--;

	        if(left > right)
	        return left-1;

	        int temp = array[left];
	        array[left] = array[right];
	        array[right] = temp;
	    }
	 }
	public static  int goodpivot1(int[] A,int i,int j)
	{
	    int group=0;
	    int p=0;
	    if(j==i+1){
	        return i;
	    }
	    if((j-i+1)<=10){
	        Arrays.sort(A,i,j+1);
	        p=i+((j-i+1)/2);
	        return p;
	    }
	    else
	    {
	        if((j-i+1)%5!=0)
	        {
	            group=((j-i+1)/5)+1;
	        }
	        else
	        {
	            group=(j-i+1)/5;
	        }
	        int a=i;
	        int b=i+4;
	        for(int h=0;h<group-1;h++)
	        {
	        Arrays.sort(A,a,b+1);
	            a=a+5;
	            b=b+5;
	        }
	            if(((j-i+1)%5)==0){b=b;}
	            else{
	        b=b-5+((j-i+1)%5);}
	            Arrays.sort(A,a,b+1);
	        int z=0;
	        int g=i+2;
	        int y=i+0;
	        while(z<group-1)
	        {    
	            int temp=A[y];
	               A[y]=A[g];
	               A[g]=temp;
	               y++;
	               z++;
	               g=g+5;
	        }
	        if(z==group-1)
	        {
	            g=i+(group-1)*5;
	            if((z=(j-i+1)%5)==0){g=g+2;}
	            else{g=g+(z/2);}
	            int temp=A[y];
	               A[y]=A[g];
	               A[g]=temp;
	        }
	        if(group>1)
	        {
	            p=goodpivot1(A,i,i+group-1);
	        }
	    }
	    return p;
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
		//int arr[]=readArray();
		int[] arr={7,8,1,4,9,6,3,2};
	    int n = arr.length;
	    int rank=4;
	    FindRankDeter obj= new FindRankDeter();
		int elem=obj.findRank(arr, rank, 0, n-1);
		System.out.println("Element with rank "+rank+" is:"+elem);
		
	}
	
}

