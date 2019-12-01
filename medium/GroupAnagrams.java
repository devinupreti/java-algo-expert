package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
PROBLEM:
Given list of strings, return groups of anagrams. Anagrams -> same chars

EXAMPLE:
["yo", "act", "flop", "tac", "cat", "oy", "olfp"] -> [[yo, oy], [act, tac, cat], [flop, olfp]]

SOLUTIONs:
1. Naive : compare every pair & check -> time : O(w^2 * n) | space : [ignoring sol space] O(n + w) - hashmap of chars and visited info
2. sort each word & hashmap -> time : O(w * nlogn) | space : O(wn) - solution


*/

public class GroupAnagrams
{
    public static void test()
    {
        List<String> list = new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "cat", "oy", "olfp"));
        List<String> list2 = new ArrayList<>(Arrays.asList("abc", "dabd", "bca", "cab", "ddba"));
        System.out.println(solutionOne(list));
        System.out.println(solutionOne(list2));

        System.out.println(solutionTwo(list));
        System.out.println(solutionTwo(list2));
    }

    ////////////////////////////////////////////////////////////////////////////////
    // SOLUTION 2 : sort each word & hash map
    ////////////////////////////////////////////////////////////////////////////////

    // time : O(w * nlogn) | space : O(wn)
    public static List<List<String>> solutionTwo(List<String> words) {
        List<List<String>> solution = new ArrayList<List<String>> ();

        // sort each word
        ArrayList<String> sortedWords = new ArrayList<String> ();
        for (String word : words)
        {
            char [] sorted = word.toCharArray();
            Arrays.sort(sorted);
            sortedWords.add(new String(sorted));
        }

        // make groups
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < sortedWords.size(); ++i)
        {
            if (map.containsKey(sortedWords.get(i)))
            {
                ArrayList<String> group = map.get(sortedWords.get(i));
                group.add(words.get(i));
                map.put(sortedWords.get(i), group);
            }
            else
            {
                ArrayList<String> group = new ArrayList<String>();
                group.add(words.get(i));
                map.put(sortedWords.get(i), group);
            }
        }

        // add groups to solution
        for (String sorted : map.keySet() )
        {
            ArrayList<String> group = map.get(sorted);
            solution.add(group);
        }

        return solution;
    }


    ////////////////////////////////////////////////////////////////////////////////
    // SOLUTION 1 : compare each pair
    ////////////////////////////////////////////////////////////////////////////////

    // helper function - checks if two strings are anagrams
    public static boolean areAnagrams(String first, String second)
    {
        if (first.length() != second.length()) { return false; }

        HashMap<Character, Integer> charCountFirst = new HashMap<>();
        for (char c : first.toCharArray())
        {
            if (charCountFirst.containsKey(c)) { charCountFirst.put(c, charCountFirst.get(c) + 1); }
            else { charCountFirst.put(c,1); }
        }

        HashMap<Character, Integer> charCountSecond = new HashMap<>();
        for (char c : second.toCharArray())
        {
            if (charCountSecond.containsKey(c)) { charCountSecond.put(c, charCountSecond.get(c) + 1); }
            else { charCountSecond.put(c,1); }
        }

        for (Character c : charCountFirst.keySet())
        {
            if (!charCountSecond.containsKey(c)) { return false; }
            if (charCountSecond.get(c) != charCountFirst.get(c)) { return false;}
        }
        return true;
    }

    // time : O(w^2 * n) | space : O(n + w)
    public static List<List<String>> solutionOne(List<String> words) {
        List<List<String>> solution = new ArrayList<List<String>> ();

        List<Boolean> visited = new ArrayList<> ();
        for (String word : words) { visited.add(false); }

        for (int i = 0; i < words.size(); i++)
        {
            if (!visited.get(i))
            {
                visited.set(i, true);
                ArrayList<String> current = new ArrayList<String> ();
                current.add(words.get(i));
                for (int j = i + 1; j < words.size(); j++)
                {
                    if (areAnagrams(words.get(i), words.get(j)))
                    {
                        current.add(words.get(j));
                        visited.set(j, true);
                    }
                }
                solution.add(current);
            }
        }
        return solution;
    }
}
