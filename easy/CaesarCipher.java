package algoexpert.easy;

/*
PROBLEM:
Return string with each char shifted by key

Solution:
add the key to char unicode value and build char []
1. time : O(n) | s : O(n)
*/

public class CaesarCipher
{
    public static void test()
    {
        System.out.println(caesarCypherEncryptor("abc", 3));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        key = key % 26;
        int base = 96; // a -> 97

        char [] solution = new char[str.length()];
        for (int i = 0; i < str.length(); ++i)
        {
            char c = str.charAt(i);
            int num = key + (int)c;
            if (num > 122) { num = (num - 122) + base;}
            solution[i] = (char) num;
        }
        return new String(solution);
    }

}
