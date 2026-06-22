/*
Problem: Rearrange Array Elements by Sign
Platform: LeetCode 2149
Difficulty: Medium

Approach:
The idea is to place positive and negative elements directly into
their correct positions in the resultant array while traversing the
input array only once.

We maintain two indices:
- 'indexPos' → points to the next even index (0, 2, 4, ...)
  where a positive element should be placed.
- 'indexNeg' → points to the next odd index (1, 3, 5, ...)
  where a negative element should be placed.

Step-by-step:
1. Create a new array 'ans' of the same size as the input array.
2. Initialize 'indexPos' to 0 and 'indexNeg' to 1.
3. Traverse the input array:
   - If the current element is positive:
        → place it at 'indexPos' in 'ans'
        → increment 'indexPos' by 2.
   - Otherwise:
        → place it at 'indexNeg' in 'ans'
        → increment 'indexNeg' by 2.
4. Return the resultant array.

This ensures:
- The array starts with a positive element.
- Positive elements occupy even indices.
- Negative elements occupy odd indices.
- The relative order of positive and negative elements is preserved.

Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {1,2,-4,-5} ;

        int[] ans = signwiseRelativeOrdering(array);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] signwiseRelativeOrdering(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        int indexPos = 0;
        int indexNeg = 1;
        for(int i=0;i<n;i++){
            if(array[i] > 0){
                ans[indexPos] = array[i];
                indexPos += 2;
            }
            else{
                ans[indexNeg] = array[i];
                indexNeg += 2;
            }
        }
        return ans;
    }
}


