package basic;

public class LCS {
	void lcs(String s1, String s2)
	{
		char[] x=s1.toCharArray();
		char[] y=s2.toCharArray();
		int m=x.length;
		int n=y.length;
		
		int[][] cache=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
				{
					cache[i][j]=0;
				}
				else if(x[i-1]==y[j-1])
				{
					cache[i][j]=1+cache[i-1][j-1];
				}
				else
				{
					cache[i][j]=Math.max(cache[i-1][j], cache[i][j-1]);
				}
			}
		}
		StringBuilder seq=new StringBuilder("");
		int i=m, j=n;
		while(i>0 && j>0)
		{
			if(x[i-1]==y[j-1])
			{
				seq=seq.append(x[i-1]);
				i--;
				j--;
			}
			else if(cache[i-1][j]>cache[i][j-1])
			{
				i--;
			}
			else 
				j--;
		}
		seq=seq.reverse();
		System.out.println(seq);
	}
	public static void main(String[] args) {
		LCS obj=new LCS();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		obj.lcs(s1, s2);
	}
}
