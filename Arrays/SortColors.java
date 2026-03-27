/*
Problem no.: 75
Problem: Sort Colors (Sort an array of 0s, 1s and 2s)
Platform: LeetCode
Difficulty: Medium

Approach:
The array contains only 0s, 1s, and 2s, so instead of using a general sorting algorithm,
we use the Dutch National Flag algorithm.

We maintain three pointers:
start -> boundary for 0s
middle -> current element being processed
end -> boundary for 2s

We iterate through the array:
- If the element is 0, swap it with the start pointer and move both start and middle forward.
- If the element is 1, just move the middle pointer.
- If the element is 2, swap it with the end pointer and move the end pointer backward.

This way, the array gets sorted in a single pass without using extra space.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class sortArrayDutch {
    public static void main(String[] args) {
        int[] arr = {1,0,2,1,0};
        int[] ans = sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] sortArray(int[] arr){
        int start = 0;
        int middle = 0;
        int end = arr.length - 1;
        while(middle <= end){
            if(arr[middle] == 0 ){
                int temp = arr[start];
                arr[start] = arr[middle];
                arr[middle] = temp;
                start++;
                middle++;
            }
            else if(arr[middle] == 1){
                middle++;
            }
            else{
                int temp = arr[middle];
                arr[middle] = arr[end];
                arr[end] = temp;
                end--;
            }
        }
        return arr;
    }
}
