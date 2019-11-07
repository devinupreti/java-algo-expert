package algoexpert.easy;

/*
PROBLEM:
Find if the given string is a palindrome

Solutions:
1. Two pointers | t: O(n) | s: O(1)
2. Stack | t: O(n) | s: O(n)
3. Recursion 
*/

public class IsPalindrome
{
    public static void test()
    {
        String testStr = "abccba";
        System.out.println(isPalindrome(testStr));
    }

    public static boolean isPalindrome(String str)
    {
        int first = 0;
        int last = str.length() - 1;

        while (first < last)
        {
            if (str.charAt(first) != str.charAt(last)) { return false; }
                first += 1;
            last -= 1;
        }
        return true;
    }
}
