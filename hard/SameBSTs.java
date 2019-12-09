package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
PROBLEM:
Given two arrays of integers each representing BSTs (formed by inserting elements in array left to right)
- without actually constructing a BST return if the arrays represent the same BSTs

EXAMPLE:
[10,15,8,5], [10,8,15,5] -> true

both represent the BST
        10
       /  \
      8    15
     /
    5

LOGIC:
- root value & length of arrays needs to be same
- values less than root will be in left subtree & greater than root will be in right subtree
- use recursion to check roots of Left-Left & Right-Right subtrees of the given arrays

SOLUTIONS:
1. Recursion : time -> O(n^2) | space -> O(n^2) - at each level of recursion we have O(n) | n is the length of arrays
2. Recursion with pointers : time -> O(n^2) | space -> O(d) - d is the depth of BST
*/

public class SameBSTs
{
    public static void test1()
    {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(sameBsts(arrayOne,arrayTwo)); // expected true
    }

    public static void test2()
    {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(5, 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(5, 8, 10, 15, 2, 8, 12, 45, 100, 2, 12, 94, 81, -1, -1, -34, 8));
        System.out.println(sameBsts(arrayOne,arrayTwo)); // expected false
    }

    public static void test3()
    {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 94, 81));
        System.out.println(sameBsts(arrayOne,arrayTwo)); // expected true
    }

    public static void test4()
    {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(50, 76, 81, 23, 23, 23, 657, 56, 12, -1, 3));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(50, 23, 76, 23, 23, 12, 56, 81, -1, 3, 657));
        System.out.println(sameBsts(arrayOne,arrayTwo)); // expected true
    }

    public static void test()
    {
        test1(); // true
        test2(); // false
        test3(); // true
        test4(); // true
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return solution2(arrayOne, arrayTwo);
    }

    ///////////////////////////////////////////////////////////////////////////
    // SOLUTION 1
    // - recurse to check left and right subtree arrays at each level
    ///////////////////////////////////////////////////////////////////////////

    public static List<Integer> smallerThanRoot(List<Integer> array)
    {
        List<Integer> smaller = new ArrayList<Integer>();
        if (array.size() < 2) { return smaller; }

        int root = array.get(0).intValue();
        for (int i = 1; i < array.size(); ++i)
        {
            if ( array.get(i).intValue() < root) { smaller.add(array.get(i).intValue()); }
        }
        return smaller;
    }

    public static List<Integer> equalOrGreaterThanRoot(List<Integer> array)
    {
        List<Integer> larger = new ArrayList<Integer>();
        if (array.size() < 2) { return larger; }

        int root = array.get(0).intValue();
        for (int i = 1; i < array.size(); ++i)
        {
            if ( array.get(i).intValue() >= root) { larger.add(array.get(i).intValue()); }
        }
        return larger;
    }

    // time -> O(n^2) | space -> O(n^2)
    public static boolean solution1(List<Integer> arrayOne, List<Integer> arrayTwo)
    {
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) { return true; }
        if (arrayOne.size() != arrayTwo.size() || arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) { return false; }

        List<Integer> firstLeftSubtree = smallerThanRoot(arrayOne);
        List<Integer> secondLeftSubtree = smallerThanRoot(arrayTwo);

        List<Integer> firstRightSubtree = equalOrGreaterThanRoot(arrayOne);
        List<Integer> secondRightSubtree = equalOrGreaterThanRoot(arrayTwo);

        return solution1(firstLeftSubtree, secondLeftSubtree) && solution1(firstRightSubtree, secondRightSubtree);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // SOLUTION 2
    // - recursion with pointer
    // - don't make array at each level, use pointers and limits to keep track of subtrees
    ////////////////////////////////////////////////////////////////////////////////////////
    
    // first smaller idx
    // minValue is the value of previous parent node
    public static int smallerIndex( List<Integer> array, int rootIdx, int minValue)
    {
        for (int i = rootIdx + 1; i < array.size(); ++i)
        {
            if (array.get(i).intValue() < array.get(rootIdx).intValue() && array.get(i).intValue() >= minValue)
            { return i; }
        }
        return -1;
    }

    // first not smaller idx
    // maxValue is the value of previous parent node
    public static int equalOrGreaterIndex(List<Integer> array, int rootIdx, int maxValue)
    {
        for (int i = rootIdx + 1; i < array.size(); ++i)
        {
            if (array.get(i).intValue() > array.get(rootIdx).intValue() && array.get(i).intValue() < maxValue)
            { return i; }
        }
        return -1;
    }

    // keep finding roots of left and right & comparing them
    public static boolean helper(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo, int minValue, int maxValue)
    {
        if (rootIdxOne == -1 || rootIdxTwo == -1) { return rootIdxOne == rootIdxTwo; }
        if (arrayOne.get(rootIdxOne).intValue() != arrayTwo.get(rootIdxTwo).intValue()) { return false; }

        int firstLeftRootIdx = smallerIndex(arrayOne, rootIdxOne, minValue);
        int secondLeftRootIdx = smallerIndex(arrayTwo, rootIdxTwo, minValue);

        int firstRightRootIdx = equalOrGreaterIndex(arrayOne, rootIdxOne, maxValue);
        int secondRightRootIdx = equalOrGreaterIndex(arrayTwo, rootIdxTwo, maxValue);

        int currentRoot = arrayOne.get(rootIdxOne);
        boolean leftAreSame = helper(arrayOne, arrayTwo, firstLeftRootIdx, secondLeftRootIdx, minValue, currentRoot);
        boolean rightAreSame = helper(arrayOne, arrayTwo, firstRightRootIdx, secondRightRootIdx, currentRoot, maxValue);

        return leftAreSame && rightAreSame;
    }

    //       root
    //     /      \
    // maxValue  minValue
    
    // time -> O(n^2) | space -> O(d)
    public static boolean solution2(List<Integer> arrayOne, List<Integer> arrayTwo)
    {
        return helper(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
