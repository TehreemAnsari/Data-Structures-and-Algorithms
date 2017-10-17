package chap5;

import java.util.ArrayList;
import java.util.Collections;

public class Question_5_3 {
	//we can check the lsb of a binary number just by checking if it is odd or even
	//if number is odd, lsb is 1, else it is 0.
	ArrayList<Integer> counts = new ArrayList<>();
	int count =0;
	void flipBit(int num)
	{
		System.out.println("Begining of flipBit(int num)");
		while(num>0)
		{
			System.out.println(Integer.toBinaryString(num));
			while(num%2==1)
			{
				System.out.println(Integer.toBinaryString(num));
				num=num>>1;
				count++;
			}
			if(num%2==0)
			{
				System.out.println(Integer.toBinaryString(num));
				counts.add(count);
				num=num>>1;
				count=0;
			}
		}
		int i=0;
		int temp;
		//int maxTrailOnes[]=new int[counts., element)]
		for(i=0;i<counts.size()-1;i++)
		{
			System.out.print(counts.get(i)+" ");
			temp=counts.get(i)+counts.get(i+1);
			System.out.println(temp);
			counts.set(i, temp);
			System.out.println(counts.get(i));
		}
		/*while(i<(counts.size()-1))
		{
			temp=counts.get(i)+counts.get(i+1);
			counts.add(i, temp);
			i++;
		}*/
		System.out.println("End of flipBit(int num)");
		System.out.println("One flip gives "+(Collections.max(counts)+1));
	}
	public static void main(String[] args) {
		Question_5_3 obj=new Question_5_3();
		obj.flipBit(1775);
	}
}
