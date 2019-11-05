package algoexpert.easy;

/*
PROBLEM:
Implement Binary Search

Solutions:
1. Recursive - t: O(log n) | s: O(log n)
2. Iterative - t: O(log n) | s: O(1)
*/

public class BinarySearch {
    public static void test()
    {
        int [] testArr = new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;

        System.out.println(binarySearch(testArr, target));
    }


    // time : O(log n) | space: O(1)
    public static int iterative(int[] array, int target){
        int first = 0;
        int last = array.length - 1;
        while(first <= last)
        {
            int middle = (first + last) / 2;

            if (array[middle] == target) { return middle; }
            else if (array[middle] < target) { first = middle + 1;}
            else { last = middle - 1;}
        }
        return -1;
    }

    // time : O(log n) | space : O(log n) - recursive stack
    public static int recursive(int[] array, int target, int first, int last){
        if (first > last) {return -1;}
        int middle = (first + last) / 2;
        if (array[middle] == target) { return middle; }
        else if (array[middle] < target) { first = middle + 1;}
        else { last = middle - 1; }

        return recursive(array, target, first, last);
    }

    public static int binarySearch(int[] array, int target) {
        //return recursive(array, target, 0, array.length - 1);
        return iterative(array, target);
    }
}
