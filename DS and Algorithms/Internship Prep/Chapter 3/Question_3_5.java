package chap3;
import java.util.*;

public class Question_3_5 {
	Stack<Integer> origStack=new Stack<Integer>();
	Stack<Integer> auxStack=new Stack<Integer>();
	
	void push(Integer item)
	{
		while(!origStack.isEmpty() && item>origStack.peek())
		{
			int value=origStack.pop();
			auxStack.push(value);
		}
		origStack.push(item);
		while(!auxStack.isEmpty())
		{
			origStack.push(auxStack.pop());
		}
	}
	Integer pop()
	{
		if(origStack.isEmpty())
		{
			System.out.println("no stack");
			return -1;
		}
		return origStack.pop();
	}
	void print()
	{
		System.out.println("Stack is:");
		for(int i=0;i<origStack.size();i++)
		{
			System.out.print(origStack.elementAt(i)+" ");
		}
	}
	public static void main(String[] args) {
		Question_3_5 obj=new Question_3_5();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		obj.print();
		obj.pop();
		obj.pop();
		obj.push(35);
		obj.print();
	}
}
