package algoexpert.medium;
/*
PROBLEM:
Find if single cycle exists in given array
-> starting at any index and following the jumps, every element is visited exactly once before landing back on the starting index

EXAMPLE:
[2,3,1,-4,-4,2] -> true

Solution:
1. HashMap -> time : O(n) | space : O(n)
2. Count visited -> time : O(n) | space : O(1) [we don't really need hashmap, just need to check if it is revisiting 0 only at end]

*/


public class SingleCycleCheck
{
    public static void test()
    {
        System.out.println(hasSingleCycle(new int [] {2,3,1,-4,-4,2}));
        System.out.println(hasSingleCycle(new int [] {1,1,1,1,2}));
    }

    public static int nextIndex(int current, int [] array)
    {
        int next = (current + array[current]) % array.length;
        if (next < 0) { next = array.length + next; }
        return next;
    }

    public static boolean hasSingleCycle(int[] array) {
        if (array.length < 1) { return true; }

        int visitedCount = 0;
        int current = 0;
        while (visitedCount < array.length)
        {
            if (visitedCount > 0 && current == 0) { return false; }

            visitedCount += 1;
            current = nextIndex(current, array);
        }
        return (current == 0) ? true : false;
    }
}
