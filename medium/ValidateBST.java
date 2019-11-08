package algoexpert.medium;

/*
PROBLEM:
Validate a BST

Solution:
1. Recursion : t: O(n) | s: O(n)
*/


public class ValidateBST {

    static class BST
    {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    // t: O(n) | s: O(n)
    public static boolean validator(BST tree, int min, int max)
    {
        if (tree == null) { return true; }

        if (tree.value < min || tree.value >= max)
        { return false; }

        return validator(tree.left, min, tree.value)
                && validator(tree.right, tree.value, max);
    }

    public static boolean validateBst(BST tree)
    {
        return validator(tree.left, Integer.MIN_VALUE, tree.value)
                && validator(tree.right, tree.value, Integer.MAX_VALUE);
    }

}
