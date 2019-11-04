package algoexpert;

import java.util.ArrayList;

/*
PROBLEM:
[Integer or ArrayList<Object>] -> sum (based on formula)
[x,[y,z,[a]]] -> x + 2y + 2z + 3a

Logic:
go over the array
if int -> add to current Sum
else -> goDeeper(array, multiplier)

Solution:
1. Recursion : T : O(n) | S : O(n)
*/

public class ProductSum {

    public static int goDeeper(ArrayList<Object> array, Integer multiplier)
    {
        int currentSum = 0;
        for (Object consider : array){
            if (consider instanceof Integer)
            {
                currentSum += ((Integer)consider * multiplier); // add to sum
            }
            else
            {
                // it is an arraylist -> go deeper
                currentSum += multiplier * goDeeper((ArrayList<Object>)consider, multiplier + 1);
            }
        }
        return currentSum;
    }

    public static int productSum(ArrayList<Object> array)
    {
        return goDeeper(array, 1);
    }
}
