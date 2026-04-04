/*
Problem no.: 18
Problem: 4Sum
Platform: LeetCode
Difficulty: Medium

Approach:
We are given an array of integers and a target value.
The goal is to find all unique quadruplets (4 numbers) whose sum equals the target.

To solve this efficiently, we first sort the array.
Sorting helps in two ways:
1. It allows us to use the two-pointer technique.
2. It helps in avoiding duplicate quadruplets.

We fix the first two elements using two loops (i and j),
and then use two pointers (left and right) to find the remaining two elements.

Steps:
1. Sort the array.
2. Iterate with index i from 0 to n-3:
   - Skip duplicates for i to avoid repeated quadruplets.
3. For each i, iterate with index j from i+1 to n-2:
   - Skip duplicates for j as well.
4. Initialize two pointers:
   - left = j + 1
   - right = n - 1
5. While left < right:
   - Calculate sum = nums[i] + nums[j] + nums[left] + nums[right]
   - If sum == target:
       → Add the quadruplet to result
       → Move both pointers (left++, right--)
       → Skip duplicates for left and right
   - If sum > target:
       → Decrease right (to reduce sum)
   - If sum < target:
       → Increase left (to increase sum)

After exploring all possibilities, return the result list.

Time Complexity: O(n³)
  (Two loops + two-pointer scan)

Space Complexity: O(1) (excluding result storage)
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
                for(int j=i+1;j<n-2;j++){
                    if(j > i+1 && nums[j] == nums[j-1])continue;
                    int left = j+1;
                    int right = n-1;
                    while(left<right){
                    sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum == target){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        result.add(ans);
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }
                    else if(sum > target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }

        }
        return result;
    }
}
