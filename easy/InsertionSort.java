package algoexpert.easy;

/*
Implement Insertion Sort
-> sorted array at arr[0]
-> insert elements in right position one by one
*/

public class InsertionSort
{
    public static void test()
    {
        int [] test = {5,1,4,3,2};
        int [] sorted = insertionSort(test);
        for (int x: sorted) { System.out.print(x + " "); }
    }

    // Best - O(n)
    // Average - O(n^2)
    // Worst - O(n^2)
    public static int [] insertionSort(int[] array)
    {
        if (array.length < 2) { return array; }

        for (int i = 1; i < array.length; ++i)
        {
            int j = i - 1;
            while (j >= 0 && array[j+1] < array[j])
            {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j = j - 1;
            }
        }
        return array;
    }
}
