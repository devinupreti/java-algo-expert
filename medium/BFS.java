package algoexpert.medium;
import java.util.*;

/*
PROBLEM:
Implement Breadth First Search

-> time : O(v+e) | space : O(v)
*/

public class BFS
{
    static class Node
    {
        String name;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name)
        {
            this.name = name;
        }

        // time : O(v+e) | space : O(v)
        public ArrayList<String> breadthFirstSearch(ArrayList<String> array)
        {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(this);

            while(queue.size() > 0)
            {
                Node current = queue.remove();
                array.add(current.name);

                for(int i = 0; i < current.children.size(); i++)
                { queue.add(current.children.get(i)); }
            }
            return array;
        }

        public Node addChild(String name)
        {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
