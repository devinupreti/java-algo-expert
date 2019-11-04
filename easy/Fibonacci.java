package algoexpert;

/*
PROBLEM:
Find Nth Fibonacci - 0, 1, 1, 2, 3, 5, 8, 13, ...

Solutions:
1. Recursive -> T: O(2^n) | S: O(n)
2. List -> T: O(n) | S: O(n)
3. Last two numbers in variables -> T : O(n) | S : O(1)
*/

public class Fibonacci {
    public static void test()
    {
        int n = 9;
        System.out.println(recursiveFib(n));
        System.out.println(listFib(n));
        System.out.println(lastTwoFib(n));
    }

    public static int recursiveFib(int n){
        if (n < 2) { return 0; }
        else if (n == 2) { return 1; }
        else{
            return recursiveFib(n-1) + recursiveFib(n-2);
        }
    }

    public static int listFib(int n){
        int[] array = new int[n];
        array[0] = 0;
        if (n < 2) { return 0; }

        array[1] = 1;
        int current = 2; // current = n - 1
        while(current < n){
            array[current] = array[current - 1] + array[current - 2];
            current++;
        }
        return array[n -1];
    }

    public static int lastTwoFib(int n){
        if (n < 2) { return 0; }
        if (n == 2) { return 1; }
        int last = 1;
        int second_last = 0;
        int current = 0;
        int count = 2;
        while (count < n){
            current = last + second_last;
            second_last = last;
            last = current;
            count += 1;
        }
        return current;
    }
}
