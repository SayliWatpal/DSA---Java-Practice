/*
Problem: Longest Subarray with Sum Zero

Approach:
We generate all possible subarrays and calculate their sums
using a running sum technique.

- The first loop selects the starting index of the subarray.
- The second loop extends the subarray one element at a time.
- A running sum is maintained by adding the current element.
- Whenever the sum becomes 0, the length of the current subarray
  is calculated as (j - i + 1).
- The maximum length among all such subarrays is stored.

At the end, the maximum length of a subarray having sum 0
is returned.

Time Complexity: O(n²)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {9, -3, 3, -1, 6, -5} ;

        int ans = longestSubarrayWithSumZero(array);
        System.out.println(ans);
    }

    public static int longestSubarrayWithSumZero(int[] array) {
        int n = array.length;
        int maxLen = 0;

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += array[j];
                if(sum == 0){
                    maxLen = Math.max(maxLen,j - i + 1);
                }
            }
        }
        return maxLen;
    }
}

/*
Problem: Longest Subarray with Sum Zero

Approach:
We use a HashMap to store the first occurrence of each prefix sum.

- Traverse the array while maintaining a running prefix sum.
- If the prefix sum becomes 0, the subarray from index 0 to the
  current index has sum 0.
- If the same prefix sum is seen again, the elements between the
  previous index and current index sum to 0.
- Store only the first occurrence of each prefix sum in the HashMap.
- Update the maximum length whenever a valid zero-sum subarray is found.

Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {9, -3, 3, -1, 6, -5} ;

        int ans = longestSubarrayWithSumZero(array);
        System.out.println(ans);
    }

    public static int longestSubarrayWithSumZero(int[] array) {
        int n = array.length;
        int maxLen = 0;
        int sum = 0;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            sum += array[i];
            if(sum == 0){
                maxLen = Math.max(maxLen,i+1);
            }
            if(map.containsKey(sum)){
              maxLen = Math.max(maxLen,i - map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}





