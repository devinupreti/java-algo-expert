package algoexpert.hard;
import java.util.HashMap;

/*
PROBLEM:
Find the largest range in the given array. Range is a set of consecutive integers. The numbers don't have to be adjacent.

EXAMPLE:
[1,11,3,0,15,5,2,4,10,7,12,6] -> [0,7]

LOGIC:
Use a HashMap to avoid visiting a number more than once
then expand

Solutions:
1. HashMap | time : O(n)  space : O(n)
2. Sort and find | time : O(nlogn)  space : O(1)
3. Search for each number | time: O(n^2)  space : O(1)

*/

public class LargestRange
{
    public static void test()
    {
        int[] testArr = {1,2};
        int[] solution = largestRange(testArr);
        System.out.println(solution[0] + ", " + solution[1]);
    }

    public static int [] expand(int x, HashMap<Integer, Boolean> map)
    {
        int start = x;
        int end = x;
        while(map.containsKey(start))
        {
            map.put(start, true);
            start -= 1;
        }
        while(map.containsKey(end))
        {
            map.put(end, true);
            end += 1;
        }
        return new int [] {start + 1, end - 1};
    }

    // time : O(n)  space : O(n)
    public static int[] largestRange(int[] array)
    {
        HashMap<Integer, Boolean> map = new HashMap<> ();
        for (int x : array)
        { map.put(x, false); }

        int start = array[0];
        int end = array[0];

        for (int x : array)
        {
            if (!map.get(x))
            {
                int [] current = expand(x, map);
                int currentStart = current[0];
                int currentEnd = current[1];
                if (currentEnd - currentStart > end - start)
                {
                    end = currentEnd;
                    start = currentStart;
                }
            }
        }
        return new int[] {start, end};
    }
}
