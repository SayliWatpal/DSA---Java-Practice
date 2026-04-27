/*
Problem: Reverse Each Word in a Sentence
Platform: Basic String Problem
Difficulty: Easy

Approach:
We are given a sentence containing multiple words.
The task is to reverse every individual word
while keeping the word order unchanged.

Steps:
1. Split the sentence into words using space (" ").
2. Create a StringBuilder to store the final result.
3. Traverse through each word:
   - Initialize an empty string rev.
   - Traverse the word from the last character
     to the first character.
   - Append each character to rev to create
     the reversed word.
4. Append the reversed word and a space
   to the StringBuilder.
5. After processing all words:
   - Remove the extra trailing space using trim().
6. Return the final reversed sentence.

Example:
Input:
"java is easy"

Reversed words:
java -> avaj
is   -> si
easy -> ysae

Output:
"avaj si ysae"

Time Complexity: O(n)
- Every character in the string is visited once.

Space Complexity: O(n)
- Extra space is used for storing reversed words
  and final output.

Pattern:
String Traversal / String Reversal
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        String input = "java is easy";
        System.out.println(reverseWords(input));
    }

    static String reverseWords(String input) {
        StringBuilder sb = new StringBuilder();
        String[] words = input.split(" ");
        for(String word : words){
            String rev = "";
            for(int i = word.length() - 1;i>=0;i--){
                rev += word.charAt(i);

            }
            sb.append(rev).append(" ");
        }
        return sb.toString().trim();
    }
}
