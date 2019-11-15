package algoexpert.medium;
import java.util.Stack;

/*
PROBLEM:
Given string with brackets - {}, (), [] and other chars; find if the brackets are in balanced order

LOGIC:
Use a stack check prev elem whenever a closing bracket comes along

SOLUTION:
1. time : O(n) | space : O(n)
*/

public class BalancedBrackets {
    public static void test()
    { System.out.println(balancedBrackets("{}()[][()]{[()]}"));}

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i)
        {
            Character current = str.charAt(i);
            if (current == '(' || current == '[' || current == '{')
            { stack.add(current); }
            else if (current == ')' || current == ']' || current == '}')
            {
                if (stack.size() == 0) { return false; }
                Character open = stack.pop();
                if (current == ')' && open != '(') { return false; }
                if (current == ']' && open != '[') { return false; }
                if (current == '}' && open != '{') { return false; }
            }
        }

        if (stack.size() > 0) { return false; }
        return true;
    }
}
