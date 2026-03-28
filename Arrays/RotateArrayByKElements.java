/*
Approach 1
Problem: Array Rotation (Left & Right)
Platform: Striver A - Z Sheet
Difficulty: Easy

Approach:
The idea is to rotate the array by k steps in either left or right direction.

For left rotation:
We copy elements starting from index k till the end of the array,
and then append the first k elements.

For right rotation:
We copy the last k elements first (from n-k to n-1),
and then append the remaining elements from the beginning.

An auxiliary array is used to store the rotated result.

While implementing, care must be taken for proper indexing,
handling k greater than array length using modulo,
and correct string comparison for direction.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class stock {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int[] result = rotateArray(nums, 2, "left");
        System.out.println(Arrays.toString(result));
    }

    static int[] rotateArray(int[] nums, int k, String direction) {
        int n = nums.length;
        k = k % n;  // handle large k
        int[] ans = new int[n];
        int index = 0;

        if (direction.equalsIgnoreCase("left")) {
            // left rotation
            for (int i = k; i < n; i++) {
                ans[index++] = nums[i];
            }
            for (int i = 0; i < k; i++) {
                ans[index++] = nums[i];
            }
        }
        else if (direction.equalsIgnoreCase("right")) {
            // right rotation
            for (int i = n - k; i < n; i++) {
                ans[index++] = nums[i];
            }
            for (int i = 0; i < n - k; i++) {
                ans[index++] = nums[i];
            }
        }

        return ans;
    }
}

/*
Approach 2 (optimal inplace solution)
Problem: Array Rotation 
Platform: Striver A - Z Sheet
Difficulty: Medium

Approach:
The idea is to rotate the array in-place using the reversal algorithm.

For right rotation:
First, reverse the entire array.
Then, reverse the first k elements.
Finally, reverse the remaining n-k elements.

For left rotation:
First, reverse the entire array.
Then, reverse the first n-k elements.
Finally, reverse the last k elements.

This approach avoids using extra space and modifies the array directly.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class stock {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] result = rotateArray(nums, 2, "right");
        System.out.println(Arrays.toString(result));
    }

    static void reverse(int[] nums, int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static int[] rotateArray(int[] nums, int k, String direction) {
        int n = nums.length;
        k = k % n;  // handle large k
        if (direction.equalsIgnoreCase("left")) {
            // left rotation
            reverse(nums,0,n-1);
            reverse(nums,0,n-k-1);
            reverse(nums,n-k,n-1);
        }
        else if (direction.equalsIgnoreCase("right")) {
            // right rotation
            reverse(nums,0,n-1);
            reverse(nums,0,k-1);
            reverse(nums,k,n-1);
        }
        return nums;
    }
}
