package algoexpert.hard;

/*
PROBLEM:
Given an array of integers maximum steps you can take at that point.
Find minimum jumps required to reach the last index.

EXAMPLE:
[3,4,2,1,2,3,7,1,1,1,3] -> 4
[3,4,2,1,2,3,7] -> 3

SOLUTIONS:
1. DP (min required at each index) -> time : O(n^2) | space : O(n)
2. Track Steps Left before Jump -> time : O(n) | space : O(1)
*/

import java.util.Arrays;

public class MinJumps
{
    public static void test()
    {
        int[] test1 = {3,4,2,1,2,3,7,1,1,1,3};
        System.out.println(minNumberOfJumps(test1)); // 4

        int[] test2 = {3, 12, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1};
        System.out.println(minNumberOfJumps(test2)); // 5
    }

    public static int minNumberOfJumps(int[] array)
    {
        return trackSteps(array);
    }

    // time : O(n) | space : O(1)
    public static int trackSteps(int[] array)
    {
        if (array.length < 2) { return 0; }

        int minJumps = 0;
        int stepsLeft = array[0];
        int maxReachable = array[0];

        for (int i = 1; i < array.length - 1; ++i)
        {
            stepsLeft -= 1;
            maxReachable = Math.max(maxReachable, i + array[i]);
            if (stepsLeft == 0)
            {
                stepsLeft = maxReachable - i;
                minJumps += 1;
            }
        }
        return minJumps + 1;
    }

    // time : O(n^2) | space : O(n)
    public static int dp(int[] array)
    {
        if (array.length < 2) { return 0; }

        int[] minJumpsTill = new int[array.length];
        Arrays.fill(minJumpsTill, Integer.MAX_VALUE);
        minJumpsTill[0] = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            int reachable = i + array[i];
            int j = i + 1;
            while(j < array.length && j <= reachable)
            {
                minJumpsTill[j] = Math.min(minJumpsTill[j], minJumpsTill[i] + 1);
                ++j;
            }
        }

        return minJumpsTill[array.length - 1];
    }
}
