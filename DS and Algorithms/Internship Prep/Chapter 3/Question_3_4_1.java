package chap3;
import java.util.*;

public class Question_3_4_1 {
	//Implementing Queue using 2 stacks
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	
	void insert(Integer item)
	{
		s1.push(item);
	}
	
	Integer remove()
	{
		if(s1.isEmpty())
		{
			System.out.println("Queue not created");
			return -1;
		}
		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
		}
		int item=s2.pop();
		while(!s2.isEmpty())
		{
			s1.push(s2.pop());
		}
		return item;
	}
	void print()
	{
		System.out.println("Queue is:");
		for(int i=0;i<s1.size();i++)
			System.out.print(s1.elementAt(i)+" ");
	}
	public static void main(String[] args) {
		Question_3_4_1 obj=new Question_3_4_1();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.print();
		System.out.println("\nElem removed is: "+obj.remove());
		obj.print();
		obj.insert(4);
		obj.insert(5);
		System.out.println("\nElem removed is: "+obj.remove());
		obj.print();
	}
}
