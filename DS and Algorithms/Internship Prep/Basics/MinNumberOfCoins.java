package basic;

public class MinNumberOfCoins {
	static int minCoinsRecursion(int[] denom, int amount)
	{
		if(amount==0)
			return 0;
		int coinsReqd=Integer.MAX_VALUE;
		for(int i=0;i<denom.length;i++)
		{
			if(denom[i]<=amount)
			{
				int recur_coinsReqd=minCoinsRecursion(denom, amount-denom[i]);
				if(recur_coinsReqd!=Integer.MAX_VALUE && recur_coinsReqd + 1< coinsReqd)
				{
					coinsReqd=recur_coinsReqd + 1;
				}
			}
		}
		return coinsReqd;
	}
	static int minCoinsDP(int[] denom, int amount)
	{
		int cache[]=new int[amount+1];
		cache[0]=0;
		for(int i=1;i<=amount;i++)
		{
			cache[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<denom.length;i++)
		{
			for(int j=1;j<=amount;j++)
			{
				if(denom[i]<=j)
				{
					int dp_coinsReqd=cache[j-denom[i]];
					if(dp_coinsReqd != Integer.MAX_VALUE && dp_coinsReqd+1<cache[j])
						cache[j]=dp_coinsReqd+1;
					
				}
			}
		}
		return cache[amount];
	}
	
	public static void main(String[] args) {
		int denom[]={9, 6, 5, 1};
		int amount=11;
		//System.out.println("Coins required are:"+minCoinsRecursion(denom, amount));
		System.out.println("Coins required are:"+minCoinsDP(denom, amount));
	}
}
