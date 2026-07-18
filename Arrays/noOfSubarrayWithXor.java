/*
Problem: Count Subarrays with Given XOR
Platform: GeeksforGeeks / Coding Ninjas
Difficulty: Medium

Approach:
The idea is to generate every possible subarray and compute the XOR of its
elements. If the XOR of a subarray equals the given value 'k', increment the count.

Step-by-step:
1. Traverse the array using index 'i' as the starting point of the subarray.
2. Initialize a variable 'xor' to 0 for every new starting index.
3. Extend the subarray one element at a time using index 'j':
      → Update the running XOR as:
            xor = xor ^ array[j]
4. After adding each element:
      → If xor == k, increment the count.
5. Continue until all possible subarrays have been checked.
6. Return the total count.

This works because:
- Every possible contiguous subarray is generated.
- Instead of recomputing the XOR for every subarray from scratch, we keep a
  running XOR while extending the subarray, making each extension O(1).

Time Complexity: O(n²)
Space Complexity: O(1)
*/


import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 6, 4};
        System.out.println(noOfSubarrayWithXor(array,6));
    }

    public static int noOfSubarrayWithXor(int[] array,int k) {
        int n = array.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int xor = 0;
            for(int j=i;j<n;j++){
                xor = xor ^ array[j];
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }
}

/*
Problem: Count Subarrays with Given XOR
Platform: GeeksforGeeks / Coding Ninjas
Difficulty: Medium

Approach:
The idea is to use Prefix XOR along with a HashMap to efficiently count
the number of subarrays whose XOR is equal to the given value 'k'.

Let:
- xr = Prefix XOR from index 0 to the current index.
- If a previous prefix XOR is equal to (xr ^ k), then the XOR of the
  subarray between that previous index and the current index will be k.

Reason:
Suppose:
- Prefix XOR till current index = xr
- Prefix XOR till a previous index = P

Then,
    P ^ (Subarray XOR) = xr

We need:
    Subarray XOR = k

So,
    P = xr ^ k

Therefore, if (xr ^ k) has already occurred, a valid subarray exists.

Step-by-step:
1. Initialize:
      → xr = 0 (stores the running prefix XOR)
      → count = 0 (stores the number of valid subarrays)
      → HashMap to store the frequency of each prefix XOR.
2. Insert (0, 1) into the HashMap.
      → This handles subarrays that start from index 0.
3. Traverse the array:
      → Update the running prefix XOR:
            xr = xr ^ array[i]
      → Compute the required prefix XOR:
            required = xr ^ k
      → If 'required' exists in the HashMap:
            → Add its frequency to the count.
      → Store/update the frequency of the current prefix XOR in the HashMap.
4. Return the total count.

This works because:
- Prefix XOR allows us to determine the XOR of any subarray in O(1).
- The HashMap keeps track of how many times each prefix XOR has occurred.
- Every occurrence of (xr ^ k) represents a valid starting point for a
  subarray ending at the current index.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 6, 4};
        System.out.println(noOfSubarrayWithXor(array,6));
    }

    public static int noOfSubarrayWithXor(int[] array,int k) {
        int n = array.length;
        int xr = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : array){
            xr ^= num;
            int req = xr^k;
            if(map.containsKey(req)){
                count += map.get(req);
            }
            map.put(xr,map.getOrDefault(xr,0) + 1);
        }
        return count;
    }
}


