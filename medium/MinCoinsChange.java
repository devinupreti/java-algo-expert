package algoexpert.medium;

/*
PROBLEM:
Find smallest number of coins needed to make target amount from given denominations

Example:
Input : {1,5,10}, 7
Output: 3

Logic:
find min coins for each amount upto n
0 -> 1
1 -> inf -> 1
2 -> inf -> 1+1
3 -> inf -> 2+1
4 -> inf -> 3+1
5 -> inf -> 4+1 -> min(5, 1) -> 1

if (coins[amount - currency] != Integer.MAX_VALUE)
   { coins[amount] = Math.min(coins[amount], coins[amount - currency] + 1); }

Solutions:
1. time : O(dn) | space: O(n)

*/

public class MinCoinsChange {

    public static void test()
    {
        System.out.println(minNumberOfCoinsForChange(7, new int[] {1,5,10}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int [] coins = new int[n+1];
        for (int i = 1; i < n+1; i++)
        { coins[i] = Integer.MAX_VALUE; }

        for (int currency : denoms)
        {
            for (int amount = 1; amount < n+1; ++amount)
            {
                if (currency <= amount)
                {
                    if (coins[amount - currency] != Integer.MAX_VALUE)
                    { coins[amount] = Math.min(coins[amount], coins[amount - currency] + 1); }
                }
            }
        }
        return (coins[n] != Integer.MAX_VALUE) ? coins[n] : -1;
    }
}
