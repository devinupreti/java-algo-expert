package algoexpert.hard;

import java.util.*;

/*
PROBLEM:
Given string of first n digits of Pi and a list of your favorite numbers(all positive).
Find smallest number of spaces that need to be added to Pi String so that all resulting numbers are in favorites list.
If no solution exists return -1.

EXAMPLE:
Pi : "3141592"
Favorites : [ "3141", "5", "31", "2", "4159", "9", "42" ]
Answer -> 2 { 31_4159_2 }

LOGIC:
Put favorite numbers in a set for fast lookup
for each index starting from end -> check each possible prefix
- prefix = substring(index, i+1)
- if we cannot put a space after -> spacesNeeded(prefix) = infinity (MAXVALUE)
- else
    - minSpacesNeeded = min (inf, minSpacesNeeded(suffix) + 1)
put answer in cache

SOLUTION:
1. DP with recursion | bottom up -> time : O(n^3 + m) -> for each index (try putting space for all after index (string slicing O(n))) & checking in set | space : O(n + m) -> for cache and hashSet
2. DP with recursion | top down -> time : O(n^3 + m) | space : O(n + m)

*/

public class PiNumbers
{
    public static void test()
    {
        String[] numbers = { "3", "314", "49", "9001", "15926535897", "14", "9323", "8462643383279", "4", "793" };
        String pi = "3141592653589793238462643383279";
        System.out.println(numbersInPi(pi, numbers)); // should return 3

        String [] numbers2 = {"3141", "5", "31", "2", "4159", "9", "42" };
        String pi2 = "3141592";
        System.out.println(numbersInPi(pi2, numbers2)); // should return 2
    }

    public static int getMinSpaces(int index, String pi, Set<String> specialNumbers, Map<Integer, Integer> cache )
    {
        if (index == pi.length()) { return -1; }
        if (cache.containsKey(index)) { return cache.get(index); }

        int minSpacesAtIndex = Integer.MAX_VALUE;
        for (int i = index; i < pi.length(); ++i)
        {
            String prefix = pi.substring(index, i+1);

            // check if we can put space after
            if (specialNumbers.contains(prefix)) {
                int minSpacesInSuffix = getMinSpaces(i + 1, pi, specialNumbers, cache);

                // int overflow
                if (minSpacesInSuffix == Integer.MAX_VALUE) {
                    minSpacesInSuffix = minSpacesInSuffix - 1;
                }

                minSpacesAtIndex = Math.min(minSpacesAtIndex, minSpacesInSuffix + 1);
            }
        }
        cache.put(index, minSpacesAtIndex);
        return cache.get(index);
    }

    // Bottom Up
    // time : O(n^3 + m) | space : O(n + m)
    public static int numbersInPi(String pi, String[] numbers)
    {
        Set<String> specialNumbers = new HashSet<>(Arrays.asList(numbers));
        Map<Integer, Integer> cache = new HashMap<>();

        // bottom up build up
        for (int i = pi.length() - 1; i >= 0; i--)
        {
            getMinSpaces(i, pi, specialNumbers, cache);
        }

        // check if solution exists
        return cache.get(0) == Integer.MAX_VALUE ? -1 : cache.get(0);
    }
}
