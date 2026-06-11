/*
Problem: Two Sum

Approach:
We check every possible pair of elements in the array.

- The first loop selects the first element.
- The second loop selects the second element.
- For each pair, we calculate their sum.
- If the sum equals the target value, return true.
- If no valid pair is found after checking all pairs,
  return false.

Time Complexity: O(n²)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {2,6,5,8,11} ;

        boolean ans = twoSum(array,15);
        System.out.println(ans);
    }

    public static boolean twoSum(int[] array,int target) {
        int n = array.length;
        boolean res = false;
        for(int i=0;i<n-1;i++){
            int sum = 0;
            for(int j=i+1;j<n;j++){
                sum = array[i] + array[j];
                if(sum == target){
                    res = true;
                }
            }
        }
        return res;
    }
}

/*
Problem: Two Sum

Approach:
We use a HashMap to store elements that have already been visited.

- Traverse the array from left to right.
- For each element, calculate the complement as
  (target - currentElement).
- Check whether the complement already exists in the HashMap.
- If it exists, a valid pair has been found and we return true.
- Otherwise, store the current element and its index in the HashMap.
- If no valid pair is found after traversing the array,
  return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {2,6,5,8,11} ;

        boolean ans = twoSum(array,14);
        System.out.println(ans);
    }

    public static boolean twoSum(int[] array,int target) {
        int n = array.length;
        boolean res = false;
        int complement =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            complement = target - array[i];
            if(map.containsKey(complement)){
                res = true;
            }
            map.put(array[i],i);
        }
        return res;
    }
}





