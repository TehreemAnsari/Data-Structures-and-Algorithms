package chap10;

public class Question_10_5 {
	int sparseSearch(String[] strings, String str, int leftIndex, int rightIndex)
	{
		if(leftIndex>rightIndex)
		{
			return -1;
		}
		int mid=(leftIndex+rightIndex)/2;
		if(strings[mid].isEmpty())
		{
			int left=mid-1;
			int right=mid+1;
			while(true)
			{
				if(left<leftIndex && right> rightIndex)
				{
					return -1;
				}
				else if(left>=leftIndex && strings[left].isEmpty()==false)
				{
					mid=left;
				}
				else if(right<=rightIndex && strings[right].isEmpty()==false)
				{
					mid=right;
				}
				left--;
				right++;
			}
		}
		if(strings[mid]==str)
		{
			return mid;
		}
		else if(strings[mid].compareTo(str)<0)
		{
			return sparseSearch(strings, str, mid+1, rightIndex);
		}
		else
		{
			return sparseSearch(strings, str, leftIndex, mid-1);
		}
	}
	int search(String[] strings, String str)
	{
		if(strings==null || str==null|| str=="")
			return -1;
		return sparseSearch(strings, str, 0, strings.length-1);
	}
}
