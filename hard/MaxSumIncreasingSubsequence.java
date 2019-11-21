package algoexpert.hard;

/*
PROBLEM:
Find the max sum possible from strictly increasing numbers in a array (not in sequence) and also the numbers in that sequence
[array] -> [[maxSum], [sequence]]

EXAMPLE:
[10,70,20,30,50,11,30] -> [ [110], [10,20,30,50] ]

SOLUTION:
1. Dynamic Programming : time : O(n^2) | space : O(n)
- build maxSum possible using this element
- keep track of prev idx if contributing to maxSum at current element

- find maxSumIdx to generate the solution
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSumIncreasingSubsequence
{
    public static void test()
    {
        System.out.println(maxSumIncreasingSubsequence(new int[] {1,2,3,4,5}));
        System.out.println(maxSumIncreasingSubsequence(new int[] {10,70,20,30,50,11,30}));
    }

    // time : O(n^2) | space : O(n)
    public static ArrayList<ArrayList<Integer>> maxSumIncreasingSubsequence(int[] array)
    {
        int [] maxUsingThis = array.clone();
        int [] prevIdxs = new int[array.length];
        Arrays.fill(prevIdxs, -1);

        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();

        int maxSumIdx = 0;
        for (int i = 1; i < array.length; ++i)
        {
            int j = 0;
            while (j < i)
            {
                if (array[j] < array[i])
                {
                    int currentMaxTill = maxUsingThis[j] + array[i];
                    if (currentMaxTill > maxUsingThis[i])
                    {
                        maxUsingThis[i] = currentMaxTill;
                        prevIdxs[i] = j;
                    }
                }
                j += 1;
            }

            if (maxUsingThis[maxSumIdx] < maxUsingThis[i])
            { maxSumIdx = i; }
        }

        ArrayList<Integer> maxSum = new ArrayList<Integer> ();
        maxSum.add(maxUsingThis[maxSumIdx]);
        solution.add(maxSum);

        ArrayList<Integer> sequence = new ArrayList<Integer> ();
        while (maxSumIdx != -1)
        {
            sequence.add(array[maxSumIdx]);
            maxSumIdx = prevIdxs[maxSumIdx];
        }
        Collections.reverse(sequence);
        solution.add(sequence);
        return solution;
    }
}
