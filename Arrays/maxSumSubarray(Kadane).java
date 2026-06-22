/*
Problem: Maximum Sum Subarray (Brute Force)
Platform: LeetCode 53 / General
Difficulty: Medium

Approach:
The idea is to generate all possible contiguous subarrays and
calculate the sum of each subarray. The maximum sum encountered
during the traversal is stored as the answer.

We maintain two variables:
- 'sum' → stores the sum of the current subarray
- 'maxSum' → stores the maximum subarray sum found so far

Step-by-step:
1. Initialize 'maxSum' to Integer.MIN_VALUE.
2. Traverse the array using the first loop to select the starting
   index of the subarray.
3. For each starting index:
   - Initialize 'sum' to 0.
   - Traverse the array from the current starting index to the end.
   - Add the current element to 'sum'.
   - If 'sum' is greater than 'maxSum':
        → update 'maxSum'.
4. After checking all possible subarrays, return 'maxSum'.

This ensures:
- Every possible contiguous subarray is considered.
- The maximum subarray sum is found correctly.

Time Complexity: O(n²)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {-2, -3, -7, -2, -10, -4} ;

        int ans = maxSumSubarray(array);
        System.out.println(ans);
    }

    public static int maxSumSubarray(int[] array) {
        int n = array.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + array[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}



/*
Problem: Maximum Sum Subarray (Kadane's Algorithm)
Platform: LeetCode 53 / General
Difficulty: Medium

Approach:
The idea is to find the maximum sum of a contiguous subarray in a
single traversal of the array using Kadane's Algorithm.

We maintain two variables:
- 'sum' → stores the sum of the current subarray
- 'maxSum' → stores the maximum subarray sum found so far

Step-by-step:
1. Initialize 'sum' to 0.
2. Initialize 'maxSum' to Integer.MIN_VALUE.
3. Traverse the array:
   - Add the current element to 'sum'.
   - If 'sum' is greater than 'maxSum':
        → update 'maxSum'.
   - If 'sum' becomes negative:
        → reset 'sum' to 0 since a negative sum cannot contribute
          to a larger subarray in the future.
4. Return 'maxSum' as the answer.

This ensures:
- The maximum subarray sum is found in a single traversal.
- Arrays containing all negative elements are handled correctly by
  updating 'maxSum' before resetting 'sum'.

Time Complexity: O(n)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {-2, -3, -7, -2, -10, -4} ;

        int ans = maxSumSubarray(array);
        System.out.println(ans);
    }

    public static int maxSumSubarray(int[] array) {
        int n = array.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += array[i];
            if(sum > maxSum){
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}


