package chap10;

public class Question_10_3 {
	int searchInRotatedArray(int a[], int leftIndex, int rightIndex, int numberToSearch)
	{
		int mid=(leftIndex+rightIndex)/2;
		if(a[mid]==numberToSearch)
		{
			return mid;
		}
		if(leftIndex>rightIndex)
		{
			return -1;
		}
		
		if(a[leftIndex]<a[mid])
		{	//left part is normally sorted
			//doing normal binary search
			if(numberToSearch>=a[leftIndex] && numberToSearch<a[mid])
			{
				return searchInRotatedArray(a, leftIndex, mid-1, numberToSearch);
			}
			else
				return searchInRotatedArray(a, mid+1, rightIndex, numberToSearch);
		}
		
		else if(a[leftIndex]>a[mid])
		{//left part is not normally sorted, right part is normally sorted
			//normal binary search on right part
			if(numberToSearch<=a[rightIndex] && numberToSearch>a[mid])
			{
				return searchInRotatedArray(a, mid+1, rightIndex, numberToSearch);
			}
			else 
				return searchInRotatedArray(a, leftIndex, mid-1, numberToSearch);
		}
		else if(a[leftIndex]==a[mid])
		{	//both are not normally sorted, ie they have repeated elems 
			if(a[mid]!=a[rightIndex])
			{
				return searchInRotatedArray(a, mid+1, rightIndex, numberToSearch);
			}
			else
			{//search both halves
				int result=searchInRotatedArray(a, leftIndex, mid-1, numberToSearch);
				if(result==-1)
				{	//ie the elem is not in the left part, so search the right
					return searchInRotatedArray(a, mid+1, rightIndex, numberToSearch);
				}
				else	//if result!=-1, then the elem was already found in the left half
					return result;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int a[]= {15,16,19,20,25,1,3,4,5,7,10,14};
		Question_10_3 obj=new Question_10_3();
		System.out.println("Number found in index:"+obj.searchInRotatedArray(a, 0, a.length-1, 19));	
	}
}
