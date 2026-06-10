/*
Problem: Maximum Consecutive Ones

Approach:
The array contains only 0s and 1s. We need to find the longest continuous sequence of 1s.

We maintain two variables:
count -> stores the current streak of consecutive 1s
max -> stores the maximum streak found so far

We traverse the array:
- If the current element is 1, increment count.
- If the current element is 0, reset count to 0 because the streak is broken.
- After processing each element, update max with the maximum of max and count.

At the end, max contains the length of the longest sequence of consecutive 1s.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 1, 1};

        int ans = maxConsecutiveOnes(array);
        System.out.println(ans);
    }

    public static int maxConsecutiveOnes(int[] array) {
        int n = array.length;
        int count = 0;
        int max = 0;
        for(int i =0;i<n;i++){
            if(array[i] == 1){
                count++;
            }
            else{
                count = 0;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}


