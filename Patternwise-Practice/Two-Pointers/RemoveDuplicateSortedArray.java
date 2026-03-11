/*
Problem: Remove Duplicates from Sorted Array
Platform: LeetCode
Difficulty: Easy

Approach:
The array is already sorted, so duplicate elements will always appear next
to each other. We use the Two Pointer technique to remove duplicates in-place.

Pointer i keeps track of the position of the last unique element.
Pointer j scans the array from left to right to find new unique elements.

If nums[j] is different from nums[i], it means we found a new unique element.
We move i forward and copy nums[j] to nums[i].

By doing this, all unique elements are placed at the beginning of the array.
The remaining elements after the unique portion are irrelevant.

Finally, the number of unique elements is i + 1.

Time Complexity: O(n)
Space Complexity: O(1)

Pattern: Two Pointers
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int k = 0;
        for(int j=1;j<n;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        k = i + 1;
        return k;
    }
}
