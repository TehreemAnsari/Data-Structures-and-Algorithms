package chap8;

public class Question_8_3 {
	int magicFast(int[] array)
	{
		return magicFastWithoutDup(array,0,array.length);
	}
	int magicFastWithoutDup(int[] array, int start, int end)
	{
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		if(array[mid]==mid)
		{
			return mid;
		}
		else if(array[mid]>mid)
		{
			return magicFastWithoutDup(array, start, mid-1);
		}
		else
		{
			return magicFastWithoutDup(array, mid+1, end);
		}
	}
	int magicFastWithDup(int[] array, int start, int end)
	{
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		if(array[mid]==mid)
		{
			return mid;
		}
		
		int leftIndex=Math.min(mid-1, array[mid]);
		int left=magicFastWithDup(array, start, leftIndex);
		if(left>=0)
		{
			return left;
		}
		
		int rightIndex=Math.max(mid+1, array[mid]);
		int right=magicFastWithDup(array, rightIndex, end);
		return right;
	}
	public static void main(String[] args) {
		Question_8_3 obj=new Question_8_3();
		int arr[]= {-40,-20,-1,1,2,3,5,7,9,12,13};
		System.out.println(obj.magicFast(arr));
		
		int arrWithDup[]= {-10,-5,2,2,2,3,4,7,9,12,13};
		System.out.println(obj.magicFastWithDup(arrWithDup, 0, arrWithDup.length));
	}
}
