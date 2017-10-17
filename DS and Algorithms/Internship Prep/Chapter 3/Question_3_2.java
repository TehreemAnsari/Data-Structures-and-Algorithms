package chap3;

public class Question_3_2 {
	int[] minArray, stack;
	static int top=-1,minIndex=-1,minValue=Integer.MAX_VALUE;
	public Question_3_2(int capacity) {
		minArray=new int[capacity];
		stack=new int[capacity];
	}
	void push(int item)
	{
		if(top>=stack.length)
		{
			System.out.println("Stack full");
			return;
		}
		top++;
		stack[top]=item;
		if(minValue>item)
		{
			minValue=item;
			minIndex++;
			minArray[minIndex]=item;
		}
	}
	int pop()
	{
		if(top<0)
		{
			System.out.println("Out of bound");
			return -1;
		}
		int item=stack[top--];
		if(item==minValue)
		{
			minIndex--;
			minValue=minArray[minIndex];
		}
		return item;
	}
	public static void main(String[] args) {
		Question_3_2 obj=new Question_3_2(4);
		obj.push(4);
		System.out.println("Min value:"+minValue);
		obj.push(7);
		System.out.println("Min value:"+minValue);
		obj.push(2);
		System.out.println("Min value:"+minValue);
		obj.push(1);
		System.out.println("Min value:"+minValue);
		obj.pop();
		System.out.println("Min value:"+minValue);
		obj.pop();
		System.out.println("Min value:"+minValue);
	}
}
