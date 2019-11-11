package algoexpert.medium;

/*
PROBLEM:
Find max sum from non-adjacent numbers in an array of positive numbers

LOGIC:
Since each number is positive:
we just need max sum possible at each index i

Solution:
1. using array:  time : O(n) | space : O(n)
2. without array : time : O(n) | space : O(1)
*/


public class MaxSubsetSum
{
    public static void test()
    {
        int [] test = {75, 105, 120, 75, 90, 135};
        int [] test2 = {7,10,12,7,9,14};

        System.out.println(maxSubsetSumNoAdjacent(test));
        System.out.println(maxSubsetSumNoAdjacent(test2));
    }

    // time : O(n) | space : O(1)
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length < 2)
        { return (array.length == 1) ? array[0] : 0; }

        int secondLast = array[0];
        int last = Math.max(array[1],array[0]);
        for (int i = 2; i < array.length; ++i)
        {
            int current = Math.max(last, array[i] + secondLast);
            secondLast = last;
            last = current;
        }
        return last;
    }
}
