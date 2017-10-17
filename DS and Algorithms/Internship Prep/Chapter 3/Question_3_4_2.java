package chap3;

import java.util.LinkedList;
import java.util.Queue;

public class Question_3_4_2 {
	//Implementing Stack using 2 queues
	Queue<Integer> q=new LinkedList<>();
	void push(Integer item)
	{
		q.add(item);
	}
	Integer pop()
	{
		if(q.isEmpty())
		{
			System.out.println("Empty stack");
			return -1;
		}
		for(int i=0;i<q.size()-1;i++)
		{
			int item=q.remove();
			q.add(item);
		}
		return q.remove();
	}
	public static void main(String[] args) {
		Question_3_4_2 obj=new Question_3_4_2();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		System.out.println("Elem popped is:"+obj.pop());
		System.out.println("Elem popped is:"+obj.pop());
		System.out.println("Elem popped is:"+obj.pop());
		System.out.println("Elem popped is:"+obj.pop());
		System.out.println("Elem popped is:"+obj.pop());
	}
}
