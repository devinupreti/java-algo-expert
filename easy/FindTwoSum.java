package algoexpert;

/*
PROBLEM:
Given array & target find pair which sum to target

Logic:
[int], target -> [smaller, larger] where smaller + larger = target
a + b = target
a = target - b
at each number b, we need target - b

Solution:
1. for each, check every other number -> T : O(n^2) | S : O{1}
2. hash set | if not found put in HT, if found return -> T : O(n) | S: O(n)
3. sort and two pointer | use two pointer to find the pair -> T : O(nlogn) | S: O(1)
4. sort and binary search | for each, do binary search -> T : O(nlogn) | S:  O(1) or log(n)
*/

import java.util.*;

public class FindTwoSum {
    public static void test() {
        int[] array = new int[] {12,11,2,6,7,8,9,3,4,5,};
        int targetSum = 9;
        int [] solution;
        solution = bruteForce(array, targetSum);
        for (int x : solution) { System.out.print(x + " "); }
        System.out.println();

        solution = withHashSet(array, targetSum);
        for (int x : solution) { System.out.print(x + " "); }
        System.out.println();

        solution = sortTwoPointer(array, targetSum);
        for (int x : solution) { System.out.print(x + " "); }
        System.out.println();

        solution = sortBinarySearch(array, targetSum);
        for (int x : solution) { System.out.print(x + " "); }
        System.out.println();
    }

    public static int[] bruteForce(int[] array, int target) {
        // go over array
        for (int i = 0; i < array.length - 1; i++){
            int current = array[i];
            int find = target - current;
            // go over rest of array to find (target - current)
            for (int j = i+1; j < array.length; j++){
                if (array[j] == find){
                    if (array[j] < current) {
                        int[] solution = {array[j], current};
                        return solution; }
                    else{
                        int[] solution = {current, array[j]};
                        return solution;
                    }
                }
            }
        }
        // no solution exists
        int[] solution = {};
        return solution;
    }

    public static int[] withHashSet(int [] array, int target) {
        // initialize the hash set with first value in array
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(array[0]); // will give exception if array size is 0

        // go over the array
        for (int i = 1; i < array.length; i++){
            int current = array[i];
            int find = target - current;
            if (set.contains(find)){
                if (array[i] < find) {
                    int[] solution = {array[i], find};
                    return solution; }
                else{
                    int[] solution = {find, array[i]};
                    return solution;
                }
            }
            else { set.add(current); }
        }
        // no solution exists
        int[] solution = {};
        return solution;
    }

    public static int[] sortTwoPointer(int [] array, int target) {
        // sort
        Arrays.sort(array);
        // two pointer
        int first = 0;
        int last = array.length - 1;

        while (first < last){
            int sum = array[first] + array[last];
            if (sum < target){
                first = first + 1;
            }
            else if (sum > target) { last = last - 1;}
            else {
                int [] solution = {array[first], array[last]};
                return solution;
            }
        }
        int [] solution = {};
        return solution;
    }

    public static int[] sortBinarySearch(int[] array, int target) {
        // sort
        Arrays.sort(array);
        // go over the array
        for(int i = 0; i < array.length - 1; i++){
            int current = array[i];
            int find = target - current;
            int first = i+1;
            int last = array.length - 1;
            while (first <= last) {
                int mid = (first + last) / 2;
                if (array[mid] == find) {
                    int[] solution = {current, find};
                    return solution;
                }
                else if (array[mid] < find) {
                    first = mid + 1;
                }
                else { last = mid - 1; }
            }
        }

        int[] solution = {};
        return solution;
    }
}
