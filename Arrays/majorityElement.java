/*
Problem: Majority Element

Approach:
We count the frequency of every element in the array.

- For each element, traverse the entire array and count how many
  times it appears.
- Keep track of the maximum frequency found so far.
- Whenever a higher frequency is found, update both the maximum
  frequency and the corresponding element.
- After checking all elements, return the element with the
  highest frequency.

Time Complexity: O(n²)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {7, 0, 0, 1, 7, 7, 2, 7, 7} ;

        int ans = majorityElement(array);
        System.out.println(ans);
    }

    public static int majorityElement(int[] array) {
        int n = array.length;
        int maxfreq = 0;
        int element = -1;
        for(int i=0;i<n;i++){
            int freq = 0;
            for(int j=0;j<n;j++){
                if(array[i] == array[j]){
                    freq++;
                }
            }
            if(freq > maxfreq){
                maxfreq = freq;
                element = array[i];
            }
        }
        return element;
    }
}


/*
Problem: Majority Element

Approach:
We use a HashMap to count the frequency of each element.

- Traverse the array and store each element in the HashMap.
- The element is the key and its frequency is the value.
- If an element already exists, increment its frequency.
- After building the frequency map, traverse all keys.
- Find the element with the highest frequency.
- Return that element as the answer.

Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {7, 0, 0, 1, 7, 7, 2, 7, 7} ;

        int ans = majorityElement(array);
        System.out.println(ans);
    }

    public static int majorityElement(int[] array) {
        int n = array.length;
        int maxfreq = 0;
        int element = -1;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i : array){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > maxfreq){
                maxfreq = map.get(key);
                element = key;
            }
        }
        return element;
    }
}


