package algoexpert.easy;

/*
PROBLEM:
Return the three largest numbers in an array in sorted order

Input : int [] array
Output: int [] {three largest}

Solution:
1. Sort -> O(n logn) | space : O(1)
2. Three variables -> O(n) | space : O(1)
*/

import java.util.Arrays;

public class FindThreeLargest
{
    // not part of problem
    public static void printArray(int [] array)
    {
        System.out.print("[ ");
        for (int x: array)
        {System.out.print(x + " ");}
        System.out.print("]");

        System.out.println();
    }
    public static void test()
    {
        int[] testArr1 = {42, 82, 47};
        int[] solution = sorter(testArr1);
        printArray(solution);
    }

    // time: O(n logn) | space : O(1)
    public static int[] sorter(int [] array)
    {
        Arrays.sort(array);
        int largest = array[array.length -1];
        int second = array[array.length -2];
        int third = array[array.length -3];

        return new int[] {third, second, largest};
    }

    // t : O(n) | s: O(1)
    public static int[] findThreeLargestNumbers(int[] array)
    {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            int current = array[i];
            if (current > third){
                if(current > second){
                    third = second;
                    if (current > largest){
                        second = largest;
                        largest = current;
                    }
                    else{ second = current; }
                }
                else{
                    third = current;
                }
            }
        }
        int [] solution = {third, second, largest};
        return solution;
    }
}
