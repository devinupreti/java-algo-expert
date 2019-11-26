package easy;

import java.util.ArrayList;
import java.util.List;

/*
PROBLEM:
Given a binary tree, find sum of all branches. Returned in left to right order.

EXAMPLE:
         1
       /  \
      2    3
     / \  / \
    4  5 6  7
   / \  \
  8  9  10              ->  [15, 16, 18, 10, 11]

SOLUTION:
1. Recursion (maintain currentSum) -> time : O(n) | space : O(n)
*/

public class BranchSums
{
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void addSums(BinaryTree current, int currentSum, ArrayList<Integer> solution)
    {
        if (current == null) return;

        currentSum += current.value;
        if (current.left == null && current.right == null)
        {
            solution.add(currentSum);
            return;
        }
        addSums(current.left, currentSum, solution);
        addSums(current.right, currentSum, solution);
    }

    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> solution = new ArrayList<Integer> ();
        addSums(root, 0, solution);
        return solution;
    }
}
