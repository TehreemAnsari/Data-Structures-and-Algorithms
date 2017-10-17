package basic;

import java.util.LinkedList;

public class Temp {
	LinkedList<String> temp=new LinkedList<>();
	void random()
	{
		temp.addFirst("1");
		temp.addLast("10");
		temp.removeFirst();
		temp.remove("1");
		
		int[] defaultValueArray=new int[10];
		for(int i=0;i<10;i++)
		{
			System.out.print(defaultValueArray[i]);
		}
				
	}
	public static void main(String[] args) {
		Temp t=new Temp();
		t.random();
		String s="tehreem";
		System.out.println(s.substring(0, s.length()-2));
	}
}
