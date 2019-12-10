package algoexpert.hard;

/*
PROBLEM:
Given an array of integers representing heights of pillars with constant width 1.
If the area is flooded, return the water area that the pillars will be able to hold.

EXAMPLE:
[0,8,0,0,5,0,0,10,0,0,1,1,0,3] -> 48
               |
   |           |
   |     |     |           ,
 _ | _ _ | _ _ | _ _ | | _ |
   8     5     10    1 1   3

LOGIC:
Traverse Left to Right - find maxLeft
Traverse Right to Left - find maxRight
total capacity at each point = min(left, right) - height [given that min(left, right) > height]

SOLUTION:
1. L to R & vice versa traversal -> time : O(n) | space : O(n)
*/

public class WaterArea
{
    public static void test()
    {
        int [] test = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterArea(test));
    }

    // time : O(n) | space : O(n)
    // the function can be optimized to use just one array for storing min(left, right)
    public static int waterArea(int[] heights)
    {
        if (heights.length == 0) return 0;

        int [] maxLeft = new int[heights.length];
        int [] maxRight = new int[heights.length];

        maxLeft[0] = 0;
        int currentMax = 0;
        for (int i = 1; i < maxLeft.length; ++i)
        {
            maxLeft[i] = currentMax;
            if (heights[i] > currentMax) { currentMax = heights[i]; }
        }

        currentMax = 0;
        for (int i = maxRight.length - 1; i >= 0; --i)
        {
            maxRight[i] = currentMax;
            if (heights[i] > currentMax) { currentMax = heights[i]; }
        }

        int waterArea = 0;
        for (int i = 0; i < heights.length; ++i)
        {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > heights[i]) waterArea = waterArea + min - heights[i];
        }

        return waterArea;
    }
}
