package algoexpert.medium;

/*
PROBLEM:
Find the youngest common ancestor to the two descendants

Logic:
If we don't have ancestor property defined in the class
we can map the path to both the nodes and compare the paths to find the common ancestor

If we have ancestor property
then bring both the nodes to the same height & iterate to find the first common ancestor

SOLUTION:
1. Iterate from same depth | time : O(d) | space : O(1)

*/


public class YoungestCommonAncestor
{
    public static int getDistance(AncestralTree root, AncestralTree node)
    {
        int distance = 0;
        while (node != root)
        {
            node = node.ancestor;
            distance += 1;
        }
        return distance;
    }

    // time : O(d) -> depth of deeper node
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo)
    {
        int distance1 = getDistance(topAncestor, descendantOne);
        int distance2 = getDistance(topAncestor, descendantTwo);

        // rather than swap, we can create a new function and pass in order
        if (distance2 > distance1)
        {
            // swap
            AncestralTree temp = descendantOne;
            descendantOne = descendantTwo;
            descendantTwo = temp;
            int tempDist = distance1;
            distance1 = distance2;
            distance2 = tempDist;
        }

        while (distance1 > distance2)
        {
            descendantOne = descendantOne.ancestor;
            distance1 -= 1;
        }

        while(descendantOne != null && descendantTwo != null && descendantOne != descendantTwo)
        {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        return descendantOne;
    }


    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
