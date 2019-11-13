package algoexpert.medium;

/*
PROBLEM:
Return power set of given array

Example:
[1,2,3] -> [ [], [1], [2], [3], [1,2], [2,3], [1,3], [1,2,3]]

Solution:
1. time : O(n * 2^n) | Space : O(2^n)
*/


import java.util.ArrayList;

public class Powerset
{
    public static void test()
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(powerset(array) );
    }

    // time  : O (n * 2^n) | space : O (n * 2^n)
    public static ArrayList<ArrayList<Integer>> powerset ( ArrayList<Integer> array)
    {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        solution.add(new ArrayList<Integer>());

        for (Integer elem : array)
        {
            int length = solution.size();
            for (int i = 0; i < length; ++i)
            {
                ArrayList<Integer> current = new ArrayList<Integer> (solution.get(i));
                current.add(elem);
                solution.add(current);
            }
        }
        return solution;
    }
}
