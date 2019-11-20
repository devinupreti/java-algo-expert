package algoexpert.hard;
import java.util.Arrays;

/*
PROBLEM:
Given a list of scores of students distribute them rewards such that
- all students must receive at least 1 reward
- any student must receive more rewards than any adjacent student with lower score & vice versa
- each score is unique
Return the minimum number of rewards you must give to the students

EXAMPLE:
[8,4,2,1,3,6,7,9,5]  ->  [4,3,2,1,2,3,4,5,1]  ->  25

SOLUTIONS AND LOGIC:
1. traversal : time : O(n^2) | space : O(n)
-------------------------------------------
Go through the array from index 1
if elem_n < elem_n+1 -> reward_n+1 = reward_n + 1
if elem_n > elem_n+1 ->
    j = n | j > -1
    while (elem_j > elem_j+1 ) { elem_j = max(elem_j, elem_j+1); j--; }

2. Local Min (Valleys & Peaks) : time : O(n) | space : O(n)
-----------------------------------------------------------
                            9
8                       7       5
    4               6
        2       3
            1

Find all the local mins ( reward = 1 )  | a > min < b
Expand until elevation breaks

3. Forward and Backward : time : O(n) | space : O(n)
----------------------------------------------------
you do the same thing as local mins but with cleaner code
forward pass -> elevation after local mins
             -> if elem_n < elem_n+1 -> reward_n+1 = reward_n + 1
backward pass -> elevation before local mins
              -> if elem_n-1 > elem_n -> reward_n-1 = max(reward_n-1, reward_n + 1)
*/


public class MinRewards
{
    public static void test()
    {
        int [] test = {0,4,2,1,3};
        int [] test2 = {2,20,13,12,11,8,4,3,1,5,6,7,9,0};
        int [] test3 = {800, 400, 20, 10, 30, 61, 70, 90, 17, 21, 22, 13, 12, 11, 8, 4, 2, 1, 3, 6, 7, 9, 0, 68, 55, 67, 57, 60, 51, 661, 50, 65, 53};
        System.out.println(minRewards(test3));
    }

    // time : O(n) | space : O(n)
    public static int minRewards(int[] scores)
    {
        int [] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (int i = 1; i < scores.length; ++i)
        {
            if ( scores[i] > scores[i - 1])
            {
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        for (int i = scores.length - 2; i > -1; --i)
        {
            if (scores[i] > scores[i + 1] )
            {
                rewards[i] = Integer.max(rewards[i], rewards[i+1] + 1);
            }
        }

        return Arrays.stream(rewards).sum();
    }
}
