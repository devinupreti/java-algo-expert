package algoexpert.medium;

/*
PROBLEM:
Given a string find its longest palindromic substring

LOGIC:
at each index check max possible
- 1 center (odd) palindrome
- 2 center (even) palindrome

Solution:
1. Brute Force - time : O(n^3) | space : O(1)
2. Index at Center - time : O(n^2) | space : O(n)
3. Use only index not strings - time : O(n^2) | space: O(1)
*/

public class PalindromeSubstring {
    public static void test()
    {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }

    public static String longestOdd(int index, String str)
    {
        int first = index;
        int second = index;
        while (first > -1 && second < str.length() && str.charAt(first) == str.charAt(second))
        {
            first -= 1;
            second += 1;
        }
        return str.substring(first + 1, second);
    }

    public static String longestEven(int index, String str)
    {
        if (index == str.length() - 1) { return ""; }

        int first = index;
        int second = index + 1;
        while (first > -1 && second < str.length() && str.charAt(first) == str.charAt(second))
        {
            first -= 1;
            second += 1;
        }
        return str.substring(first + 1, second);
    }

    // time : O(n^2) | space : O(n)
    public static String longestPalindromicSubstring(String str)
    {
        String longestSubstring = "";

        for (int i = 0; i < str.length(); ++i )
        {
            // check 1
            String odd = longestOdd(i, str);
            // check 2
            String even = longestEven(i, str);
            String longer = (odd.length() > even.length()) ? odd : even;

            if (longer.length() > longestSubstring.length())
            { longestSubstring = longer; }
        }
        return longestSubstring;
    }
}
