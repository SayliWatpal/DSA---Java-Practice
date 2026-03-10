/*
Problem no.: 136
Problem: Single Number
Platform: LeetCode
Difficulty: Easy

Approach:
As said to use linear time complexity and constant 
extra space so i have done using xor operation
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i=1;i<n;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}

