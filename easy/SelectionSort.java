package algoexpert.easy;

/*
Implement Selection Sort
-> select min element and put it in the beginning

it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
*/

public class SelectionSort
{
    public static void test()
    {
        int [] test = {5,1,4,3,2};
        int [] sorted = selectionSort(test);
        for (int x: sorted) { System.out.print(x + " "); }
    }

    // returns index of minimum elem in range
    public static int findMinElem(int [] array, int start)
    {
        int minimum = start;
        for (int i = start+1; i <= array.length - 1; ++i)
        {
            if (array[i] < array[minimum]) { minimum = i; }
        }
        return minimum;
    }

    public static int[] selectionSort(int [] array)
    {
        for (int i = 0; i < array.length; ++i)
        {
            int minimum = findMinElem(array, i);
            int temp = array[i];
            array[i] = array[minimum];
            array[minimum] = temp;
        }
        return array;
    }
}
