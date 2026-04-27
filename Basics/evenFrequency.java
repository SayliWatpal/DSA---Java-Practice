/*
Problem: Count Elements with Even Frequency
Platform: Basic DSA / HashMap Problem
Difficulty: Easy

Approach:
We are given an integer array.
The task is to count how many distinct elements
appear an even number of times in the array.

To solve this efficiently, we use a HashMap
to store the frequency of each element.

Steps:
1. Create a HashMap where:
   - Key   = array element
   - Value = frequency of that element

2. Traverse through the array:
   - If the element already exists in the map,
     increase its frequency by 1.
   - Otherwise, add it with frequency 1.

3. Traverse through all keys in the map:
   - Check if the frequency is even
     using frequency % 2 == 0.
   - If true, increase count.

4. Return the final count.

Example:
arr = [1, 2, 2, 3, 3, 3]

Frequencies:
1 -> 1
2 -> 2
3 -> 3

Only element 2 has even frequency.

Output = 1

Time Complexity: O(n)
- One traversal for frequency counting
- One traversal for checking frequencies

Space Complexity: O(n)
- HashMap stores frequencies of elements.

Pattern:
HashMap / Frequency Counting
*/
import java.util.*;

public class stock {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        int ans = evenFrequency(arr);
        System.out.println(ans);
    }

    static int evenFrequency(int[] arr) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int element : arr){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }
            else{
                map.put(element,1);
            }
        }

        for(Integer key : map.keySet()){
            if(map.get(key) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
