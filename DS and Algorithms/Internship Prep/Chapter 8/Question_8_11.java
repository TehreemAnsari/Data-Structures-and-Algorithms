package chap8;

public class Question_8_11 {
	//store the previously computed value. Store a map for reach pair <amount, index> to the preomputed result
	//read: http://www.algorithmist.com/index.php/Coin_Change
	//read: http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	int makeChange(int n)
	{
		int[] denom= {25, 10, 5, 1};
		int[][] map= new int[n+1][denom.length];
		return makeChange(n, denom, 0, map);
	}
	int makeChange(int amount, int[] denoms, int index, int[][] map)
	{
		if(map[amount][index]>0)
		{
			return map[amount][index];
		}
		if(index>=denoms.length-1)
		{
			return 1;
		}
		int denomAmount=denoms[index];
		int ways=0;
		for(int i=0;i*denomAmount<=amount;i++)
		{
			int amountRemaining=amount-i*denomAmount;
			ways=ways+makeChange(amountRemaining, denoms, index+1, map);
		}
		map[amount][index]=ways;
		return ways;
	}
}
