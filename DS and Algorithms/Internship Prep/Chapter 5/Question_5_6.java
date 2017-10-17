package chap5;

public class Question_5_6 {
	int bitWiseSwap(int a, int b)
	{
		int count=0;
		for(int c=a^b;c!=0; c=c&(c-1))
		{
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Question_5_6 obj=new Question_5_6();
		System.out.println(obj.bitWiseSwap(10, 5));
	}
}
