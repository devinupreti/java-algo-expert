package algoexpert.hard;

/*
PROBLEM:
Find max path sum of a binary tree.
A path is collection of connected nodes where no node is connected to more than two nodes.

LOGIC:
Each node can either be
- root
- part of path
Maintain Max globalRoot

SOLUTION:
1. Recursion : time - O(n) | space - O(log n)
*/

public class MaxPathSum
{
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // returns { GlobalMaxAsRoot, maxInPath}
    public static int [] traverse(BinaryTree node)
    {
        if (node == null) { return new int[] {0, 0}; }

        int [] maxPathSumsLeft = traverse(node.left);
        int [] maxPathSumsRight = traverse(node.right);

        int maxAsRoot = node.value + maxPathSumsLeft[1] + maxPathSumsRight[1];
        int maxInPath = node.value + Integer.max(maxPathSumsLeft[1], maxPathSumsRight[1]);
        maxInPath = maxInPath < 0 ? 0 : maxInPath;

        maxAsRoot = Integer.max( Integer.max(maxPathSumsLeft[0], maxPathSumsRight[0]), maxAsRoot);

        return new int[] {maxAsRoot, maxInPath};
    }

    // main function
    // time : O(n) | space : O(log n) - recursive stack
    public static Integer maxPathSum(BinaryTree tree) {
        int [] maxPathSums = traverse(tree);
        return maxPathSums[0] > maxPathSums[1] ? maxPathSums[0] : maxPathSums[1];
    }
}
