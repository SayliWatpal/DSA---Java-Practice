/*
Problem: Find the Longest Word with Odd Length
Platform: Basic String Problem
Difficulty: Easy

Approach:
We are given a sentence containing multiple words.
The task is to find the longest word whose
length is odd.

Steps:
1. Split the sentence into words using space (" ").
2. Initialize:
   - longestOdd = 0
   - ans = ""

3. Traverse through each word:
   - Count the number of characters in the word.
   - Check whether the length is odd using:
       length % 2 != 0

4. If the word length is odd and greater than
   the current longest odd length:
   - Update longestOdd
   - Store the current word in ans

5. After checking all words, return ans.

Example:
Input:
"this apple coder"

Word lengths:
this  -> 4 (even)
apple -> 5 (odd)
coder -> 5 (odd)

Both "apple" and "coder" have odd length 5,
but "apple" is returned because it appears first
and the condition uses > instead of >=.

Output:
apple

Time Complexity: O(n)
- Every character of the string is visited once.

Space Complexity: O(n)
- Space used for storing split words.

Pattern:
String Traversal / Conditional Checking
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        String input = "this apple coder";
        System.out.println(longestOddLength(input));
    }

    static String longestOddLength(String input) {

        String[] words = input.split(" ");
        int longestOdd = 0;
        String ans = "";

        for(String word : words){
            int count = 0;
            for(int i=0;i<word.length();i++){
                count++;
            }
            if(count % 2 != 0 && count > longestOdd){
                longestOdd = count;
                ans = word;
            }
        }

        return ans;
    }
}
