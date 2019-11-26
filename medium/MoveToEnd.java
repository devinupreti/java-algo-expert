package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
PROBLEM:
Given array and elem, move all instances of elem to end without using extra space.

EXAMPLE:
[2,1,2,2,2,3,4,2] -> [1,3,4,2,2,2,2,2] (1,3 & 4 can be in any order)

SOLUTION:
1. using pointers -> time : O(n) | space : O(1)
*/

public class MoveToEnd
{
    public static void test()
    {
        ArrayList<Integer> array = new ArrayList<> (Arrays.asList(2,1,2,2,2,3,4,2));
        System.out.println(moveElementToEnd(array, 2));
    }

    // time : O(n) | space : O(1)
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove)
    {
        int lastNonElem = array.size() - 1;
        int front = 0;
        while (front < lastNonElem)
        {
            while(lastNonElem > front && array.get(lastNonElem) == toMove) { lastNonElem -= 1; }
            if (array.get(front) == toMove)
            {
                array.set(front, array.get(lastNonElem));
                array.set(lastNonElem, toMove);
            }
            front += 1;
        }

        return array;
    }
}
