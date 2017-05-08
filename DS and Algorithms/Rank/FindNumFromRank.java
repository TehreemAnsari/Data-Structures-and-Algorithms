package findRank;

public class FindNumFromRank {
	public static void main(String[] args) {
		int[] arr={7,8,1,4,9,6,3,2};	//array of nos
		int rank=5;
		int n = arr.length;	
		//we can use any sorting function.
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
		for (int i = 0; i < arr.length; i++) {
			//System.out.println(arr[i]);
			if(arr.length-i==rank)
				System.out.println("Element with rank "+rank+" is:"+arr[i]);
		}
}
}