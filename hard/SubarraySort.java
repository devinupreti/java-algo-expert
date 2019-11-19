package algoexpert.hard;

/*
PROBLEM:
Given an array, return the start and end endices of the subarray which when sorted makes the whole array sorted.
- array is at least of length 2

EXAMPLE:
[1,2,4,7,10,11,7,12,6,7,16,18,19] -> [3,9]

LOGIC:
Two ways to solve:
Both -> find min, max numbers not in order and find their position

1. Find range -> MinMax -> Expand
- Find prospective start and end by checking array[i] < array[i+1] & vice versa
- Now that we have a range find its min and max
- expand range : first if any index less than it's index > min from range & vice versa
- return expanded range

2. MinMax -> Expand
- check each elem for OutOfOrder & find min, max elem among them
*/


public class SubarraySort
{
    public static void test()
    {
        int [] test1 = new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int [] test2 = new int[] {2,1};
        int [] test3 = new int[] {1,2,4,7,10,11,7,12,7,7,16,18,19};
        int [] pair = subarraySort(test3);
        System.out.println(pair[0] + ", " + pair[1]);
    }

    public static int[] subarraySort(int[] array)
    {
        return solutionTwo(array);
    }

    // SOLUTION 2
    // ========================================================
    public static boolean isOutOfOrder(int index, int [] array)
    {
        if(index == 0)
        { return array[index] > array[index + 1]; }
        else if (index == array.length - 1)
        { return array[index] < array[index - 1]; }
        else
        { return array[index] > array[index + 1] || array[index] < array[index - 1]; }
    }

    public static int[] solutionTwo(int[] array)
    {
        int minElem = Integer.MAX_VALUE;
        int maxElem = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; ++i)
        {
            if (isOutOfOrder(i, array))
            {
                minElem = Integer.min(minElem, array[i]);
                maxElem = Integer.max(maxElem, array[i]);
            }
        }

        if (minElem == Integer.MAX_VALUE) { return new int[] {-1, -1}; }

        int start = 0;
        while (array[start] <= minElem)
        {
            start += 1;
        }
        int end = array.length - 1;
        while (array[end] >= maxElem)
        {
            end -= 1;
        }
        return new int[] {start, end};
    }


    // SOLUTION 1
    // ============================================================
    public static int[] findMinMax(int start, int end, int[] array)
    {
        int min = array[start];
        int max = array[end];

        for(int i = start; i < end + 1; ++i)
        {
            if (min > array[i]) { min = array[i]; }
        }

        for (int i = end; i > start - 1; --i)
        {
            if (max < array[i]) { max = array[i]; }
        }

        return new int[] {min, max};
    }

    public static int[] solutionOne(int[] array)
    {
        // Find Prospective Range
        int first = 0;
        while (first < array.length - 1)
        {
            if (array[first] > array[first + 1])
            { break; }
            first += 1;
        }
        if (first == array.length - 1)
        { return new int[] {-1, -1}; }

        int second = array.length - 1;
        while (second > 0)
        {
            if (array[second - 1] > array[second])
            { break; }
            second -= 1;
        }

        // Find Min Max in Prospective Range
        int[] minMax = findMinMax(first, second, array);
        int minInRange = minMax[0];
        int maxInRange = minMax[1];

        // Expand
        for(int i = 0; i < first; ++i)
        {
            if (array[i] > minInRange)
            {
                first = i;
                break;
            }
        }
        for(int i = array.length - 1; i > second; --i)
        {
            if (array[i] < maxInRange)
            {
                second = i;
                break;
            }
        }
        return new int[] {first, second};
    }
}
