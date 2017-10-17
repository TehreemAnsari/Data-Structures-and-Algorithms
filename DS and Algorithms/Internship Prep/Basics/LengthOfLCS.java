package basic;

public class LengthOfLCS {
	int lcs(char[] x, char[] y)
	{
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
		return cache[m][n];
	}
	public static void main(String[] args) {
		LengthOfLCS obj=new LengthOfLCS();
		 String s1 = "AGGTAB";
		 String s2 = "GXTXAYB";
		 char[] x=s1.toCharArray();
		 char[] y=s2.toCharArray();
		 System.out.println("Longest seq is of len:"+obj.lcs(x, y));
	}
}
