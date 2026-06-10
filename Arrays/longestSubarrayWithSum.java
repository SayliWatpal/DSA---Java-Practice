/*
Problem: Longest Subarray with Sum K

Approach:
We generate all possible subarrays and check their sums.

- The first loop selects the starting index of the subarray.
- The second loop selects the ending index of the subarray.
- The third loop calculates the sum of elements between the
  starting and ending indices.
- If the sum equals k, we calculate the length of that subarray.
- We keep track of the maximum length among all valid subarrays.

After checking all possible subarrays, the maximum length is returned.

Time Complexity: O(n³)
Space Complexity: O(1)
*/

import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 7, 1, 9};

        int ans = longestSubarrayWithSum(array,15);
        System.out.println(ans);
    }

    public static int longestSubarrayWithSum(int[] array,int x) {
        int n = array.length;

        int len = 0 ;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k = i;k<=j;k++){
                    sum += array[k];
                }
                if(sum == x){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }

  
}

/*
Problem: Longest Subarray with Sum K

Approach:
We use the Sliding Window (Two Pointer) technique to find the
longest subarray whose sum is equal to k.

- Two pointers, left and right, represent the boundaries of the
  current window (subarray).
- A variable sum stores the sum of elements currently inside the window.
- The right pointer expands the window by including new elements.
- If the sum becomes greater than k, the left pointer shrinks the
  window by removing elements from the beginning.
- Whenever the sum equals k, the length of the current window is
  calculated and the maximum length is updated.
- The process continues until the right pointer reaches the end
  of the array.

Time Complexity: O(n)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 7, 1, 9};

        int ans = longestSubarrayWithSum(array,15);
        System.out.println(ans);
    }

    public static int longestSubarrayWithSum(int[] array,int x) {
        int n = array.length;
        int sum = array[0];
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while(right < n){
            while(left <= right && sum > x){
                sum -= array[left];
                left ++ ;
            }
            if(sum == x){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
            if(right < n){
                sum += array[right];
            }
        }
        return maxLen;
    }
}



