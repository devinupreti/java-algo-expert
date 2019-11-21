package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
PROBLEM:
Find the longest common subsequence of two strings

EXAMPLE:
"ZXVVYZW", "XKYKZPW" -> ["X", "Y", "Z", "W"]

Solution:
1. DP & build sequence : time : O(mn) | space : O(mn)
2. Recursion : time : O( 2 ^ (m + n) ) | space : O(m + n)


*/

public class LongestCommonSubsequence
{
    public static void test()
    {
        System.out.println(longestCommonSubsequence("ZXVVYZW" , "XKYKZPW"));
        System.out.println(longestCommonSubsequence("ABCDEFGH", "ABCDEFGH"));
    }

    public static ArrayList<Character> longestCommonSubsequence(String str1, String str2)
    {
        int[][] maxCommonTillMatrix = new int[str1.length() + 1][str2.length() + 1];
        Arrays.fill(maxCommonTillMatrix[0], 0);
        for (int row = 0; row < maxCommonTillMatrix.length; ++row)
        { maxCommonTillMatrix[row][0] = 0; }

        // find max common count
        for (int row = 1; row < maxCommonTillMatrix.length; ++row)
        {
            for (int col = 1; col < maxCommonTillMatrix[0].length; ++col)
            {
                if (str1.charAt(row - 1) == str2.charAt(col - 1))
                {
                    maxCommonTillMatrix[row][col] = maxCommonTillMatrix[row - 1][col - 1] + 1;
                }
                else
                {
                    maxCommonTillMatrix[row][col] = Integer.max(maxCommonTillMatrix[row - 1][col],
                            maxCommonTillMatrix[row][col - 1]);
                }
            }
        }

        // build sequence
        ArrayList<Character> solution = new ArrayList<Character>();
        int row = maxCommonTillMatrix.length - 1;
        int col = maxCommonTillMatrix[0].length - 1;
        while (row > 0 && col > 0)
        {
            if (str1.charAt(row - 1) == str2.charAt(col - 1))
            {
                solution.add(str1.charAt(row - 1));
                row = row - 1;
                col = col - 1;
            }
            else
            {
                if (maxCommonTillMatrix[row - 1][col] > maxCommonTillMatrix[row][col - 1])
                { row = row - 1; }
                else
                { col = col - 1; }
            }
        }
        Collections.reverse(solution);
        return solution;
    }
}
