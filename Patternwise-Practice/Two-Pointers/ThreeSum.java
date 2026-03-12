/*
Problem no.: 15
Problem: 3Sum
Platform: LeetCode
Difficulty: Medium

Approach:
The goal is to find all unique triplets in the array whose sum equals zero.

First, we sort the array. Sorting helps us efficiently apply the Two Pointer
technique and also makes it easier to avoid duplicate triplets.

We iterate through the array using index i. For every element nums[i], we try
to find two other numbers such that:

nums[i] + nums[left] + nums[right] = 0

Two pointers are used:
- left starts from i + 1
- right starts from the end of the array

We calculate the sum of the three numbers.

1. If the sum is equal to 0, we add the triplet to the result list.
2. To avoid duplicate triplets, we skip duplicate values for both
   left and right pointers.
3. If the sum is less than 0, we move the left pointer forward
   to increase the sum.
4. If the sum is greater than 0, we move the right pointer backward
   to decrease the sum.

We also skip duplicate values for index i to ensure that only unique
triplets are included in the result.

Time Complexity: O(n²)
Space Complexity: O(1) (excluding the result list)

Pattern: Two Pointers + Sorting
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length - 2 ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                    
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
}
