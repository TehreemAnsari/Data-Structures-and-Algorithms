package chap5;

public class Question_5_4 {
	//this is not the correct algo, it doesnot give the correct answer!!
	/*int next_equal_setbits(int N)
	{
		int K1 = N & -N;
		int M = N + K1;
		int K2 = M & -M;
		return K2 + ((K2/K1)>>1) - 1;
	}*/
	
	
	int snoob(int x)
	{
		 
		int rightOne;
		int nextHigherOneBit;
		int rightOnesPattern;
		int next = 0;
		 
		  if(x>=0)
		  {
		 
		    // right most set bit
		    rightOne = x & -x;
		    //-x is actually stored as 2's compliment in the computer
		 System.out.println("x="+x);
		 System.out.println("-x="+(-x));
		 System.out.println("~x="+(~x));
		    // reset the pattern and set next higher bit
		    // left part of x will be here
		    nextHigherOneBit = x + rightOne;
		 
		    // nextHigherOneBit is now part [D] of the above explanation.
		 
		    // isolate the pattern
		    rightOnesPattern = x ^ nextHigherOneBit;
		 
		    // right adjust pattern
		    rightOnesPattern = (rightOnesPattern)/rightOne;
		 
		    // correction factor
		    rightOnesPattern >>= 2;
		 
		    // rightOnesPattern is now part [A] of the above explanation.
		 
		    // integrate new pattern (Add [D] and [A])
		    next = nextHigherOneBit | rightOnesPattern;
		  }
		 
		  return next;
		}
	public static void main(String[] args) {
		Question_5_4 obj=new Question_5_4();
		//System.out.println(obj.next_equal_setbits(156));
		
		System.out.println(obj.snoob(156));
		System.out.println(~15);
		System.out.println(-15);
		int t=15;
		System.out.println(~t);
		System.out.println(-t);
	}
}
