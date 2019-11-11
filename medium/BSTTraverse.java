package algoexpert.medium;
import java.util.ArrayList;

/*
PROBLEM:
Traverse BST
    - inorder
    - preorder
    - postorder

time : O(n) | space : O(n)
*/


public class BSTTraverse
{
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static ArrayList<Integer> inOrderTraverse(BST tree, ArrayList<Integer> array) {
        // LnR
        if (tree != null)
        {
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static ArrayList<Integer> preOrderTraverse(BST tree, ArrayList<Integer> array) {
        // nLR
        if (tree != null)
        {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static ArrayList<Integer> postOrderTraverse(BST tree, ArrayList<Integer> array) {
        // LRn
        if (tree != null)
        {
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array;
    }
}
