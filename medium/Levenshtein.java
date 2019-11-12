package algoexpert.medium;

/*
PROBLEM:
Find minimum number of edit operations needed on string1 to obtain string2
Operations | each with cost of 1
- insert
- delete
- substitution

EXAMPLE:
"abc"
"yabd"
-> 2 (insert y, substitute c with d)

LOGIC:
Calculate edit distance for each pair of substrings in matrix
to construct solution for strings

if (str1.charAt(row - 1) == str2.charAt(col - 1))
{ minDistance[row][col] = minDistance[row - 1][col - 1]; }
else
{ minDistance[row][col] = 1 + Math.min(minDistance[row - 1][col - 1], Math.min(minDistance[row][col - 1], minDistance[row - 1][col])); }

prev diagonal elem -> substitution -> current
prev row elem -> insert/delete -> current
prev col elem -> insert/delete -> current

SOLUTION:
1. DP - matrix of edit ops | time : O(nm) | space : O(nm)

*/

public class Levenshtein
{
    public static void test()
    { System.out.println(levenshteinDistance("abc", "yabd"));}

    public static int levenshteinDistance(String str1, String str2)
    {
        int[][] minDistance = new int[str1.length() + 1][str2.length() + 1];

        for (int row = 1; row <  minDistance.length; ++row)
        { minDistance[row][0] = minDistance[row - 1][0] + 1; }

        for (int col = 1; col <  minDistance[0].length; ++col)
        { minDistance[0][col] = minDistance[0][col - 1] + 1; }


        for (int row = 1; row <  minDistance.length; ++row)
        {
            for (int col = 1; col <  minDistance[0].length; ++col)
            {
                if (str1.charAt(row - 1) == str2.charAt(col - 1))
                {
                    minDistance[row][col] = minDistance[row - 1][col - 1];
                }
                else
                {
                    minDistance[row][col] = 1 + Math.min(minDistance[row - 1][col - 1],
                            Math.min(minDistance[row][col - 1],
                                    minDistance[row - 1][col]));
                }
            }
        }

        return minDistance[str1.length()][str2.length()];

    }
}
