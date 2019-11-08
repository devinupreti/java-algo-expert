package algoexpert.medium;
import java.util.ArrayList;
import java.util.Arrays;

/*
PROBLEM:
Find all triplets that sum upto target
Return in ascending order

LOGIC:
a + b + c = k
a + b = k - c [Two Sum -> O(n)]

Solutions:
1. Sort and Two pointer -> t: O(n^2) | space: O(n) -> solution array
2. Brute Force -> t: O(n^3) | s : O(n)
3. Binary Search (for every two) -> t : O(n^2 log n) | s : O(n)
4. Search in set (for every two) -> t : O(n^2) | s : O(n + m) -> set
*/

public class ThreeSum
{
    public static <T> void printArr(T [] array)
    {
        for (T x : array) { System.out.print(x + " "); }
        System.out.println();
    }

    public static void test()
    {
        int [] test = {12,3,1,2,-6,5,-8,6};
        int target = 0;
        for (Integer [] triplet : threeNumberSum(test, target) ) { printArr(triplet);}
    }

    public static ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum)
    {
        Arrays.sort(array);
        ArrayList<Integer[]> solution = new ArrayList<Integer[]> ();

        for (int i = 0; i < array.length - 2; ++i)
        {
            int first = i + 1;
            int last = array.length - 1;

            int findSum = targetSum - array[i];
            while(first < last)
            {
                int currentSum = array[first] + array[last];
                if (currentSum == findSum)
                {
                    // add to solution
                    Integer [] triplet = new Integer[] { array[i], array[first], array[last]};
                    solution.add(triplet);
                    first += 1;
                    last -= 1;
                }
                else if (currentSum < findSum)
                {
                    first += 1;
                }
                else
                { last -= 1 ; }
            }
        }
        return solution;
    }
}
