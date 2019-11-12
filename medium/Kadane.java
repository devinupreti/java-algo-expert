package algoexpert.medium;

/*
PROBLEM:
Find max sum from an non-empty sub-array (only adjacent elements)  

EXAMPLE:
[3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4] -> 19 (1,3,-2,3,4,7,2,-9,6,3,1)

Solution:
1. time : O(n) | space : O(1)
find maxSum possible at each index (include or start new)

*/

public class Kadane
{
    public static void test()
    {
        System.out.println(kadanesAlgorithm(new int[] {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4}));
    }

    public static int kadanesAlgorithm(int[] array)
    {
        int current = array[0];
        int maxSum = current;
        for (int i = 1; i < array.length; ++i)
        {
            current = Math.max(array[i], current + array[i]);
            if (current > maxSum) { maxSum = current; }
        }
        return maxSum;
    }
}
