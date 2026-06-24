/*
Problem: Longest Consecutive Sequence
Difficulty: Medium

Approach:
For every element in the array, assume it is the starting point
of a consecutive sequence.

We maintain:
- x → current element in the sequence
- count → length of the current consecutive sequence
- longest → maximum sequence length found so far

Step-by-step:
1. Traverse each element of the array.
2. For the current element, repeatedly check whether the next
   consecutive number (x + 1) exists in the array using linear search.
3. If found:
      → increment x
      → increment count
4. Continue until the next consecutive number is not present.
5. Update longest with the maximum value between longest and count.
6. After checking all elements, return longest.

Time Complexity: O(n³) in the worst case
Space Complexity: O(1)
*/

import java.sql.SQLOutput;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};

        int ans = longestConsecutiveSequence(array);
        System.out.println(ans);
    }

    public static int longestConsecutiveSequence(int[] array) {
        int n = array.length;
        int longest = 1;
        if (array.length == 0) {
            return 0;
        }
        for(int i=0;i<n;i++){
            int x = array[i];
            int count = 1;
            while(linearSearch(array,x+1) == true){
                x+=1;
                count+=1;
            }
            longest = Math.max(longest,count);
        }
        return longest;

    }

    public static boolean linearSearch(int[] array,int num){
        for(int i=0;i< array.length;i++){
            if(array[i] == num){
                return true;
            }
        }
        return false;
    }

}


/*
Problem: Longest Consecutive Sequence
Difficulty: Medium

Approach:
The idea is to use a HashSet for O(1) lookup and only start
counting from elements that are the beginning of a sequence.

We maintain:
- set → stores all unique elements of the array
- count → length of the current consecutive sequence
- longest → maximum sequence length found so far

Step-by-step:
1. Insert all array elements into a HashSet.
2. Traverse each element in the set.
3. Check whether (current element - 1) exists:
      → If it exists, skip the element because it is not the
        start of a sequence.
      → If it does not exist, this element is the start of a sequence.
4. Keep checking for consecutive elements (x + 1) in the set.
5. Increment count for every consecutive element found.
6. Update longest with the maximum value between longest and count.
7. Return longest.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.sql.SQLOutput;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};

        int ans = longestConsecutiveSequence(array);
        System.out.println(ans);
    }

    public static int longestConsecutiveSequence(int[] array) {
        int n = array.length;
        if( n == 0){
            return 0;
        }
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:array){
            set.add(i);
        }
        for(int it : set){
           if(!set.contains(it-1)){
               int count =1;
               int x = it;

               while(set.contains(x+1)){
                   x += 1;
                   count += 1;
               }
               longest = Math.max(longest,count);
           }
        }
        return longest;
    }
}


