package chap3;

public class Question_3_1 {
	int[] topOfStack, nextIndex, stackData;
	int nextAvailable=0;
	public Question_3_1(int numStacks, int capacity) {
		topOfStack=new int[numStacks];
		for(int i=0;i<numStacks;i++)
		{
			topOfStack[i]=-1;
		}
		nextIndex=new int[capacity];
		stackData=new int[capacity];
		for(int i=0;i<capacity-1;i++)
		{
			nextIndex[i]=i+1;
		}
		nextIndex[capacity-1]=-1;
	}
	void push(int item, int stack)
	{
		if(stack<0 || stack>=topOfStack.length)
		{
			System.out.println("Invalid stack number");
			return;
		}
		if(nextAvailable<0)
		{
			System.out.println("No space");
			return;
		}
		int currentIndex=nextAvailable;
		nextAvailable=nextIndex[currentIndex];
		stackData[currentIndex]=item;
		nextIndex[currentIndex]=topOfStack[stack];
		topOfStack[stack]=currentIndex;
	}
	int pop(int stack)
	{
		if(stack<0 || stack>=topOfStack.length || topOfStack[stack]<0)
		{
			System.out.println("Out of bound");
			return -1;
		}
		int currentIndex=topOfStack[stack];
		topOfStack[stack]=nextIndex[currentIndex];
		int item=stackData[currentIndex];
		nextIndex[currentIndex]=nextAvailable;
		nextAvailable=currentIndex;
		return item;
	}
	void printStack(int[] temp)
	{	System.out.println("Stack is:");
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]);
	}
	public static void main(String[] args) {
		Question_3_1 ks=new Question_3_1(3, 10);
		// Let us put some items in stack number 2
	    ks.push(15, 2);
	    ks.push(45, 2);
	 
	    // Let us put some items in stack number 1
	    ks.push(17, 1);
	    ks.push(49, 1);
	    ks.push(39, 1);
	 
	    // Let us put some items in stack number 0
	    ks.push(11, 0);
	    ks.push(9, 0);
	    ks.push(7, 0);
	    
	    System.out.println("Elem popped from stack 2 is "+ks.pop(2));
	    System.out.println("Elem popped from stack 1 is "+ks.pop(1));
	    System.out.println("Elem popped from stack 0 is "+ks.pop(0));
	}
}
