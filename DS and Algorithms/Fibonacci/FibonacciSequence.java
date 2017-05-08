package fibonacci;

import java.io.IOException;
import java.util.ArrayList;
//Length of seq=200
//Fibonacci%=67
//Time taken:224 msec
public class FibonacciSequence {
	static int n[]=new int[100000];
	int m=75;
	public void getSequence()
	{
		ArrayList<Integer> seq = new ArrayList<>();
		int a=0, b=1, c=-1, p=1;
		seq.add(a);
		seq.add(b);	
		while(true)
		{
			c=(a+b)%m;
			seq.add(c);
			a=b;
			b=c;
			p++;
			if(c==0)//checking if new value matches with 1st value in seq
			{
				int d=a+b;
				if(d==1)//if new value matches, check if 2nd value matches
				{
					//if both values matches, pattern has started to repeat. hence break
					break;
				}
			}
		}	//pattern found, end of while
		System.out.println("Length of seq="+p);
		int index=getValueFromSeq(p);	//get index at which the fibo of number lies in seq
		System.out.println("Fibonacci%="+seq.get(index));
		
	}
	public int getValueFromSeq(int p)
	{
		int x=0;
		int rem=0, newn;
		for(int i=0;i<n.length;)
		{
			while(i<n.length && x<p)
			{
				x=x*10+n[i];
				i++;
			} //while breaks bcoz of either of 1 condition
			if(x<p)
				rem=x;
			else
			{
				rem=x%p;
				newn=x/p;
				x=rem;
			} //end of else
		}// end of for
		return rem;
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime=System.currentTimeMillis();
		n=(new CommonMethods().readArray(n));
		FibonacciSequence f=new FibonacciSequence();
		f.getSequence();
		long endTime=System.currentTimeMillis();
		System.out.println("Time taken:"+(endTime-startTime)+" msec");
	}
}
