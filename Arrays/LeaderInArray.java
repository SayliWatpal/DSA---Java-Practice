/*
Problem: Leaders in an Array (Brute Force)
Platform: GeeksforGeeks / General
Difficulty: Easy

Approach:
The idea is to check every element and determine whether it is a
leader. An element is considered a leader if there is no element
greater than it on its right side.

We maintain:
- 'leader' → a boolean variable that indicates whether the current
  element is a leader.

Step-by-step:
1. Traverse the array from left to right.
2. For each element:
   - Assume it is a leader by setting 'leader' to true.
   - Traverse all elements to its right.
   - If any element on the right is greater than the current element:
        → set 'leader' to false.
        → break out of the inner loop.
3. If 'leader' remains true:
   - Add the current element to the answer list.
4. Return the list of leaders.

This ensures:
- Every element is compared with all elements to its right.
- All leaders are correctly identified.
- The leaders are stored in the same order as they appear in the array.

Time Complexity: O(n²)
Space Complexity: O(n)      // O(1) auxiliary space + O(n) for storing the answer
*/


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 0} ;

        List<Integer> ans = leaderInArray(array);
        System.out.println(ans);
    }

    public static List<Integer> leaderInArray(int[] array) {
        int n = array.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean leader = true;
            for(int j=i+1;j<n;j++){
                if(array[j] > array[i]){
                    leader = false;
                    break;
                }
            }
            if(leader == true) ans.add(array[i]);
        }
        return ans;
    }
}


/*
Problem: Leaders in an Array (Optimal)
Platform: GeeksforGeeks / General
Difficulty: Easy

Approach:
The idea is to traverse the array from right to left while keeping
track of the maximum element encountered so far. Since the rightmost
element has no elements to its right, it is always a leader.

We maintain:
- 'max' → stores the maximum element encountered so far while
  traversing from right to left.

Step-by-step:
1. Initialize 'max' to Integer.MIN_VALUE.
2. Traverse the array from the last element to the first.
3. For each element:
   - If the current element is greater than 'max':
        → it is a leader.
        → add it to the answer list.
        → update 'max' with the current element.
4. Reverse the answer list to restore the original left-to-right order.
5. Return the answer list.

This ensures:
- Every element is visited only once.
- All leaders are identified efficiently.
- The output maintains the original order of the leaders.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 0} ;

        List<Integer> ans = leaderInArray(array);
        System.out.println(ans);
    }

    public static List<Integer> leaderInArray(int[] array) {
        int n = array.length;
        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(array[i] > max){
                ans.add(array[i]);
                max = array[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}


