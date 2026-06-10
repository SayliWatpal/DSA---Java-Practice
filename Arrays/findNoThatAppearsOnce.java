/*
Problem: Single Number

Approach:
Every element in the array appears twice except one element
that appears only once.

We use a HashMap to store the frequency of each element.

- Traverse the array and count the occurrences of every element.
- Store each element as a key and its frequency as the value.
- Traverse the array again and check the frequency of each element.
- The element whose frequency is 1 is the required answer.

If no such element exists, return -1.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {4,1,2,1,2};

        int ans = findNoThatAppearsOnce(array);
        System.out.println(ans);
    }

    public static int findNoThatAppearsOnce(int[] array) {
        int n = array.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : array){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i : array){
            if(map.get(i) == 1){
                return i;
            }
        }
        return -1;
    }
}


