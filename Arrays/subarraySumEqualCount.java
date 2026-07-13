/*
Problem: Subarray Sum Equals K
Platform: LeetCode 560
Difficulty: Medium

Approach:
The idea is to generate every possible subarray and calculate its sum.
If the sum of a subarray equals k, we increment the count.

Step-by-step:
1. Run the first loop with index 'i' to choose the starting index of the subarray.
2. Run the second loop with index 'j' to choose the ending index of the subarray.
3. For every subarray from index i to j, run a third loop to calculate its sum.
4. If the calculated sum equals k, increment the count.
5. Continue until all possible subarrays have been checked.
6. Return the total count of subarrays whose sum equals k.

Time Complexity: O(n³)
Space Complexity: O(1)
*/


import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        int ans = subarraySumEqual(array,3);
        System.out.println(ans);
    }

    public static int subarraySumEqual(int[] array,int k) {
        int n = array.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum =0;
                for(int x=i;x<=j;x++){
                    sum += array[x];
                }
                if(sum == k){
                    count ++;
                }
            }
        }
        return count;
    }
}


