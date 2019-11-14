package algoexpert.medium;

/*
PROBLEM:
Given matrix, find position of target
- rows & columns sorted
- height and width may not be equal

LOGIC:
t - target

c, c+1, c+2, .... , c + n
start with last col and find when c < t < c+1, go down in row

Solution:
1. time : O(m + n) | space : O(1)

*/

public class SearchSortedMatrix
{
    public static void test()
    {
        int[][] matrix = { {1,4,7,12,15,1000},
                           {2,5,19,31,32,1001},
                           {3,8,24,33,35,1002},
                           {40,41,42,44,45,1003},
                           {99,100,103,106,128,1004}
                         };
        int [] position = searchInSortedMatrix(matrix, 44);
        System.out.println("row : " + position[0]);
        System.out.println("col : " + position[1]);

    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;

        while (row < matrix.length && col > -1)
        {
            if (target < matrix[row][col])
            { col -= 1; }
            else if (target > matrix[row][col])
            { row += 1; }
            else
            { return new int[] {row, col}; }
        }

        return new int[] {-1, -1};
    }
}
