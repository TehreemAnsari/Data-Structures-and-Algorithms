package chap3;

import java.util.LinkedList;
import java.util.Stack;

public class Question_3_3 {
	LinkedList<Stack<Integer>> stacks=new LinkedList<Stack<Integer>>();
	static int capacity=3;
	static int numberOfElems=0;
	void push(int item)
	{
		if(stacks.isEmpty() || stacks.getLast().size()>=capacity)
		{
			Stack<Integer> newStack=new Stack<>();
			System.out.println("Stack is full, adding new stack");
			newStack.push(item);
			stacks.add(newStack);	//don't use stacks.push(newStack), this will not give correct answer because
									//stacks is a LinkedList collection and not Stack collection
			numberOfElems++;
			return;
		}
		else 
		{
			stacks.getLast().push(item);
			numberOfElems++;
		}
	}
	
	Integer pop()
	{
		if(stacks.isEmpty())
		{
			System.out.println("Empty");
			return -1;
		}
		Integer item=stacks.getLast().pop();
		if(stacks.getLast().isEmpty())
		{
			stacks.pop();
		}
		--numberOfElems;
		return item;
	}
	void printStack()
	{	System.out.println("Stack is:");
		for(Stack<Integer> s:stacks)
		{
			for(Integer item: s)
			{
				System.out.print(item+" ");
			}
			System.out.println();
		}
		System.out.println("Number of elems:"+numberOfElems);
	}
	Integer popAt(int index)
	{
		int elem = -1,j=-1;
		if(stacks.isEmpty())
		{
			System.out.println("Stack not created");
			return -1;
		}
		if(index<0 || index>=numberOfElems)
		{
			System.out.println("Out of bounds");
			return -1;
		}
		for(Stack<Integer> s : stacks)
		{
			for(int i=0;i<s.size();i++)
			{
				j++;
				System.out.println("In double for");
				System.out.println("Value of j="+j+" and index="+index);
				if(j==index)
				{
					elem=s.elementAt(i);
					s.removeElementAt(i);
					--numberOfElems;
					return elem;
				}
			}
		}
		return elem;
	}
	public static void main(String[] args) {
		Question_3_3 obj=new Question_3_3();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.printStack();
		obj.push(4);
		obj.push(5);
		obj.printStack();
		obj.pop();
		obj.push(6);
		obj.pop();
		obj.printStack();
		obj.push(7);
		obj.printStack();
		System.out.println("Elem popped is:"+obj.popAt(3));
		obj.printStack();
	}
}	
