/*
Problem: Find Second Largest Element in an Array
Platform: General / HackerRank / LeetCode Variation
Difficulty: Easy-Medium

Approach:
The idea is to find the second largest element in a single traversal of the array.

We maintain two variables:
- 'largest' → stores the maximum element found so far
- 'second' → stores the second largest element

Step-by-step:
1. Initialize 'largest' with the first element of the array.
2. Initialize 'second' with -1 (or minimum possible value).
3. Traverse the array starting from index 1:
   - If the current element is greater than 'largest':
        → update 'second' to previous 'largest'
        → update 'largest' to current element
   - Else if the current element is greater than 'second'
     AND not equal to 'largest':
        → update 'second' with current element
4. Return 'second' as the result.

This ensures:
- Duplicates of the largest element are ignored
- The second largest distinct element is found efficiently

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class stock {
    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 6, 5};
        int ans = secondLargest(nums);
        System.out.println(ans);
    }

    static int secondLargest (int[] nums) {

        int largest = nums[0];
        int second = -1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] > largest ){
                second = largest;
                largest = nums[i];
            }
            else if(nums[i] > second && nums[i] != largest ){
                second = nums[i];
            }
        }
        return second;
    }
}
