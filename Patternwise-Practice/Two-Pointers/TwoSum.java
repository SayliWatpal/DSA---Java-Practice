/*
Problem no.: 167
Problem: Two Sum II - Input Array Is Sorted
Platform: LeetCode
Difficulty: Medium

Approach:
The given array is already sorted in non-decreasing order, so we can use
the Two Pointer technique.

Initialize two pointers:
- i at the beginning of the array
- j at the end of the array

Calculate the sum of elements at these two pointers.

1. If the sum equals the target, return their indices (1-based indexing).
2. If the sum is greater than the target, move the right pointer (j) left
   to reduce the sum.
3. If the sum is smaller than the target, move the left pointer (i) right
   to increase the sum.

This process continues until the pair with the target sum is found.

Time Complexity: O(n)
Space Complexity: O(1)

Pattern: Two Pointers
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] ans = new int[2];
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
            else if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return ans;

    }
}
