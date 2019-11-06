package algoexpert.easy;

/*
Implement Bubble Sort
-> repeatedly swap the adjacent elements if they are in wrong order
*/

public class BubbleSort {

    public static void test()
    {
        int [] test = {5,1,4,3,2};
        int [] sorted = bubbleSort(test);
        for (int x: sorted) { System.out.print(x + " ");}
    }

    // Best - O(n)
    // Average - O(n^2)
    // Worst - O(n^2)
    public static int[] bubbleSort(int[] array) {
        if(array.length < 2) { return array; }

        boolean isSorted = false;
        while(!isSorted)
        {
            isSorted = true;
            for(int i = 0; i < array.length - 1; i++)
            {
                if (array[i] > array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
