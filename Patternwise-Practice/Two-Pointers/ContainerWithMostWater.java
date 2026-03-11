/*
Problem No.: 11
Problem: Container With Most Water
Platform: LeetCode
Difficulty: Medium

Approach:
The problem asks us to find two lines that together with the x-axis
form a container that can hold the maximum amount of water.

We use the Two Pointer technique:
- One pointer (left) starts at the beginning of the array.
- Another pointer (right) starts at the end of the array.

At every step we calculate the area formed by the two lines:
Area = min(height[left], height[right]) × (right - left)

The minimum height determines the water level because water
cannot exceed the shorter boundary.

After calculating the area, we update the maximum area found so far.

To potentially find a larger container, we move the pointer
that has the smaller height inward. This is because moving the
taller line cannot increase the area while the shorter line
remains the limiting factor.

This process continues until the two pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)

Pattern: Two Pointers
*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = Math.min(height[left],height[right]) * (right-left);
            maxArea = Math.max(area,maxArea);
            if(left < right){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
