package algoexpert.medium;

/*
PROBLEM:
Generate all possible permutations

Example:
[1,2,3] -> [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]

Solution:
1. Recursion -> Time : O(n! * n^2) | Space : O(n! * n)
2. Index Swap -> Time : O(n! * n) | Space : O(n! * n)
*/

import java.util.ArrayList;

public class Permutations
{
    public static void test()
    {
        ArrayList<Integer> testArr = new ArrayList<Integer>();
        testArr.add(1);
        testArr.add(2);
        testArr.add(3);
        System.out.println(getPermutations(testArr));
    }

    // SOLUTION 1

    // Time : O(n! * n^2) | Space : O(n! * n)
    public static void recursionHelper(ArrayList<Integer> build, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> solution)
    {
        if (array.size() == 0 && build.size() > 0)
        {
            solution.add(build);
            return;
        }

        for (int i = 0; i < array.size(); ++i)
        {
            ArrayList<Integer> newArray = new ArrayList<Integer> (array);
            newArray.remove(i);
            ArrayList<Integer> newBuild = new ArrayList<Integer> (build);
            newBuild.add(array.get(i));
            recursionHelper(newBuild, newArray, solution);
        }
    }

    // SOLUTION 2

    public static void swap(ArrayList<Integer> array, int i, int j)
    {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    // time : O(n! * n) | space : O(n! *n)
    public static void indexHelper(int index, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> solution)
    {
        if (index == array.size() - 1)
        {
            solution.add(new ArrayList<Integer>( array));
            return;
        }

        for (int j = index; j < array.size(); ++j)
        {
            swap(array, index, j);
            indexHelper(index + 1, array, solution);
            swap(array, index, j);
        }
    }

    public static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> array)
    {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        //recursionHelper(new ArrayList<Integer>(), array, solution);
        indexHelper(0, array, solution);
        return solution;
    }
}
