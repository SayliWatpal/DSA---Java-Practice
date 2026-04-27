/*
Problem: First Element Occurring K Times
Platform: Basic DSA / HashMap Problem
Difficulty: Easy

Approach:
We are given an integer array and a value k.
The task is to find the first element whose
frequency in the array is exactly equal to k.

To solve this efficiently, we use a HashMap
to count the frequency of each element.

Steps:
1. Create a HashMap where:
   - Key   = array element
   - Value = frequency of the element

2. Traverse through the array:
   - If the element already exists in the map,
     increase its frequency.
   - Otherwise, insert it with frequency 1.

3. Traverse through the array again:
   - For each element, check if its frequency
     in the map is equal to k.
   - The first element satisfying this condition
     is returned immediately.

4. If no such element exists, return -1.

Example:
arr = [1, 7, 4, 3, 4, 8, 7]
k = 2

Frequencies:
1 -> 1
7 -> 2
4 -> 2
3 -> 1
8 -> 1

The first element with frequency 2 is 7.

Output = 7

Time Complexity: O(n)
- One traversal for frequency counting
- One traversal for finding the answer

Space Complexity: O(n)
- HashMap stores frequencies of elements.

Pattern:
HashMap / Frequency Counting
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        int[] arr = {1,7,4,3,4,8,7};
        int ans = firstkOccuring(arr,2);
        System.out.println(ans);
    }

    static int firstkOccuring(int[] arr,int k) {

       Map<Integer,Integer> map = new HashMap<>();
       for(int element : arr){
           if(map.containsKey(element)){
               map.put(element,map.get(element)+1);
           }
           else{
               map.put(element,1);
           }
       }
       for(int element : arr){
           if(map.get(element) == k){
               return element;
           }
       }
       return -1;
    }
}
