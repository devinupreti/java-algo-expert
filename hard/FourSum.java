package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
PROBLEM:
Given array, find all quadruplets that sum to target
a + b + c + d = target

LOGIC:
loop through array
- for unseen elements | check sum in hash table
- for seen elements | add sum in hash table

SOLUTIONS:
1. Forward and Backward Loop - time : O(n^2) | space : O(n^2) - n^2 currentSum combinations
        - worst case : O(n^3) [going through HashMap]

2. Sort and Three Sum (Two Pointer) - time : O(n^3) | space : O(1) - not accounting space for quadruplets
 
*/

public class FourSum
{
    public static void test()
    {
        int [] test = {-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 4;

        ArrayList<Integer []> quadruplets = fourNumberSum(test, target);
        for (Integer[] quad : quadruplets)
        {
            for (int x : quad)
            { System.out.print(x + " ");}
            System.out.println();
        }
    }


    public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum)
    {
        return faster(array, targetSum);
    }

    // time : O(n^2) | space : O(n^2)
    public static ArrayList<Integer[]> faster(int[] array, int targetSum)
    {
        ArrayList<Integer[]> solution = new ArrayList<Integer[]>();
        HashMap<Integer, ArrayList<Integer[]>> sumPairs = new HashMap<>();

        for (int i = 0; i < array.length - 1; ++i)
        {
            for (int j = i+1; j < array.length; ++j)
            {
                int findSum = targetSum - array[i] - array[j];
                if (sumPairs.containsKey(findSum))
                {
                    ArrayList<Integer []> list = sumPairs.get(findSum);
                    for (Integer[] pair : list)
                    { solution.add(new Integer[] {pair[0], pair[1], array[i], array[j]} ); }
                }
            }

            for (int k = 0; k < i; ++k)
            {
                int currentSum = array[i] + array[k];
                if (sumPairs.containsKey(currentSum))
                {
                    ArrayList<Integer []> list = sumPairs.get(currentSum);
                    list.add(new Integer[] {array[k], array[i]});
                    sumPairs.put(currentSum, list);
                }
                else
                {
                    ArrayList<Integer []> list = new ArrayList<>();
                    list.add(new Integer[] {array[k], array[i]});
                    sumPairs.put(currentSum, list);
                }
            }
        }
        return solution;
    }

    // time : O(n^3) | space : O(1) - not accounting space for quadruplets
    public static ArrayList<Integer[]> slower(int[] array, int targetSum)
    {
        ArrayList<Integer[]> solution = new ArrayList<Integer[]>();

        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; ++i)
        {
            for (int j = i+1; j < array.length; ++j)
            {
                int first = array[i];
                int second = array[j];
                int newTarget = targetSum - first - second;

                int front = j + 1;
                int back = array.length - 1;
                while (front < back)
                {
                    if (array[front] + array[back] == newTarget)
                    {
                        Integer [] fourNums = {first, second, array[front], array[back]};
                        solution.add(fourNums);
                        front += 1;
                        back -= 1;
                    }
                    else if (array[front] + array[back] < newTarget)
                    {
                        front += 1;
                    }
                    else
                    {
                        back -= 1;
                    }
                }
            }
        }
        return solution;
    }
}
