package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;

/*
PROBLEM:
Traverse a 2D matrix in zigzag order
- start by going down & then top right diagonal

EXAMPLE:
[[1,  3,  4, 10],
 [2,  5,  9, 11],
 [6,  8, 12, 15],
 [7, 13, 14, 16]]   -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

SOLUTION:
1. Traversal : O(n) | Space : O(1)
- 4 possible movements
    - down
    - left
    --------------------
    - top right diagonal
    - top left diagonal

- first decide down or left -> then diagonal
*/



public class ZigZag
{
    public static void test1()
    {
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));
        System.out.println(zigzagTraverse(test));
    }

    public static void test2()
    {
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 12, 19)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 13, 18, 20)));
        test.add(new ArrayList<Integer>(Arrays.asList(7, 14, 17, 21, 24)));
        test.add(new ArrayList<Integer>(Arrays.asList(15, 16, 22, 23, 25)));
        System.out.println(zigzagTraverse(test));
    }

    public static void test()
    {
        test1();
        test2();
    }

    public static boolean isValid(int row, int col, ArrayList<ArrayList<Integer>> array)
    {
        return (row >= 0) && (row < array.size()) && (col >= 0) && (col < array.get(0).size());
    }

    // time : O(n) | space : O(1)
    public static ArrayList<Integer> zigzagTraverse(ArrayList<ArrayList<Integer>> array)
    {
        ArrayList<Integer> solution = new ArrayList<Integer> ();
        int row = 0;
        int col = 0;

        while (row < array.size() && col < array.get(0).size())
        {
            solution.add(array.get(row).get(col));

            // down or left logic
            if ( (col == 0 && row != array.size() - 1) || col == array.get(0).size() - 1)
            { row += 1;  }
            else
            { col +=  1; }

            // diagonal logic
            if (isValid(row, col, array))
            {
                if (row == array.size() - 1 || col == 0) // bottom || left
                {
                    // go diagonal top right
                    while (row != 0 && col != array.get(0).size() - 1)
                    {
                        solution.add(array.get(row).get(col));
                        row -= 1;
                        col += 1;
                    }
                }
                else // top || right
                {
                    // go diagonal bottom left
                    while (row != array.size() - 1 && col != 0)
                    {
                        solution.add(array.get(row).get(col));
                        row += 1;
                        col -= 1;
                    }
                }

            }
        }
        return solution;
    }
}
