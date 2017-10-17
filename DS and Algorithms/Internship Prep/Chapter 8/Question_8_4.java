package chap8;

import java.util.HashSet;

//A Java program to print all subsets of a set
class Question_8_4
{
	// Print all subsets of given set[]
	static void printSubsets(HashSet<Character> set)
	{
		int n = set.size();
		Object[] s;
		s=set.toArray();

		// Run a loop for printing all 2^n
		// subsets one by one
		for (int i = 0; i < (1<<n); i++)
		{
			System.out.print("{ ");

			// Print current subset
			for (int j = 0; j < n; j++)

				// (1<<j) is a number with jth bit 1
				// so when we 'and' them with the
				// subset number we get which numbers
				// are present in the subset and which
				// are not
				if ((i & (1 << j)) > 0)
				{
					System.out.print((char)s[j] + " ");
					System.out.println("i & (1 << j)="+(i & (1 << j)));
				}

			System.out.println("}");
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		//char set[] = {'a', 'b', 'c'};
		HashSet<Character> set=new HashSet<>();
		set.add('a');
		set.add('b');
		set.add('c');
		printSubsets(set);
	}
}
