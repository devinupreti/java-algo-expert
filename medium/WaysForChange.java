package algoexpert.medium;

/*
PROBLEM:
Given denominations, find max ways to make amount

LOGIC:
how can we make each amount upto n
n    ways
0 -> 1
1 -> 1 (1)
2 -> 1 (1)
..
5 -> 2 (1 or 5)
6 -> 2 (1 or {1,5})

Solution:
for each denom -> calculate ways for each amount
1. time : O(dn) | space : O(n)

*/

public class WaysForChange
{
    public static void test()
    {
        System.out.println(numberOfWaysToMakeChange(6, new int[] {1,5}));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int [] ways = new int[n+1];
        ways[0] = 1;

        for (int currency : denoms)
        {
            for (int amount = 1; amount < n+1; amount++)
            {
                if (currency <= amount)
                { ways[amount] += ways[amount - currency]; }
            }
        }
        return ways[n];
    }


}


