package algoexpert.medium;

import java.util.Arrays;

/*
PROBLEM:
Find numbers from two different arrays whose absolute difference is smallest

Logic:
[a, a+1, a+2]
[b, b+1, b+2]

Solution:
1. Brute Force -> t : O(nm) | s : O(1)
2. Sort & two pointer -> t : O(nlogn + mlogm) | s: O(1)

*/


public class SmallestDifference
{
    public static void test()
    {
        int[] arr1 = {-1, 5, 10, 20, 28, 3};
        int[] arr2 = {26, 134, 135, 15, 17};

        int[] sol = smallestDifference(arr1, arr2);
        System.out.println("[ " + sol[0] + ", " + sol[1] + " ]");
    }

    // time : O(nlogn + mlogm) | space: O(1)
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo)
    {
        if (arrayOne.length < 1 || arrayTwo.length < 1) { return new int[] {}; }

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] smallestDiffNum = { arrayOne[0], arrayTwo[0] };
        int smallestDiff = Math.abs(arrayOne[0] - arrayTwo[0]);

        int firstP = 0;
        int secondP = 0;

        while (firstP < arrayOne.length && secondP < arrayTwo.length)
        {
            int currentDiff = Math.abs(arrayOne[firstP] - arrayTwo[secondP]);
            if (currentDiff < smallestDiff)
            {
                smallestDiff = currentDiff;
                smallestDiffNum[0] = arrayOne[firstP];
                smallestDiffNum[1] = arrayTwo[secondP];
            }

            if ( arrayOne[firstP] < arrayTwo[secondP] )
            {
                firstP += 1;
            }
            else
            {
                secondP += 1;
            }
        }
        return smallestDiffNum;
    }
}
