package algoexpert;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Problem:
Implement DFS for Tree

DFS - O(v + e)
1. Recursion
2. Stack
*/

public class DFS {
    static class Node{
        String name;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        // implementation part begins
        // --------------------------
        public ArrayList<String> useRecursion(ArrayList<String> array) {
            array.add(this.name);
            for (Node child : children){
                child.useRecursion(array);
            }
            return array;
        }

        public ArrayList<String> useStack(ArrayList<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while(!queue.isEmpty()) {
                Node current = queue.poll();
                array.add(current.name);

                for (Node child : current.children) {
                    queue.add(child);
                }
            }
            return array;
        }

        public ArrayList<String> depthFirstSearch(ArrayList<String> array)
        {
            return this.useRecursion(array);
        }
    }
}
