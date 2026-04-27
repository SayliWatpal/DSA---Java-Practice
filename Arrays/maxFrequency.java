/*
Problem: Find Element with Maximum Frequency
Platform: Basic DSA / HashMap Problem
Difficulty: Easy

Approach:
We are given an integer array.
The task is to find the element that appears
the maximum number of times in the array.

To solve this efficiently, we use a HashMap
to store the frequency of each element.

Steps:
1. Create a HashMap where:
   - Key   = array element
   - Value = frequency of that element

2. Traverse through the array:
   - If the element already exists in the map,
     increase its frequency by 1.
   - Otherwise, insert it with frequency 1.

3. Initialize:
   - maxfreq = 0
   - maxElement = 0

4. Traverse through all keys in the map:
   - Compare the frequency of each element
     with maxfreq.
   - If frequency is greater:
       update maxfreq
       update maxElement

5. Return maxElement.

Example:
arr = [1, 2, 2, 3, 3, 3]

Frequencies:
1 -> 1
2 -> 2
3 -> 3

Element with highest frequency = 3

Output:
3

Time Complexity: O(n)
- One traversal for frequency counting
- One traversal for finding maximum frequency

Space Complexity: O(n)
- HashMap stores frequencies of elements.

Pattern:
HashMap / Frequency Counting
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        System.out.println(maxFrequency(arr));
    }

    static int maxFrequency(int[] arr) {
        int maxfreq = 0;
        int maxElement = 0;
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
            if(map.get(key) > maxfreq){
                maxfreq = map.get(key);
                maxElement = key;
            }
        }
        return maxElement;
    }
}
