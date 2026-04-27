/*
Problem: Count Words Starting with a Vowel
Platform: Basic String Problem
Difficulty: Easy

Approach:
We are given a sentence containing multiple words.
The task is to count how many words start with a vowel.

Vowels considered:
a, e, i, o, u

Steps:
1. Split the sentence into words using space (" ").
2. Initialize count = 0.
3. Traverse through each word:
   - Extract the first character using charAt(0).
   - Check whether the character is a vowel.
4. If the first character is a vowel:
   - Increase count by 1.
5. After checking all words, return count.

Example:
Input:
"apple is orange umbrella cat"

Words starting with vowels:
apple
is
orange
umbrella

Total = 4

Output:
4

Time Complexity: O(n)
- Every word is checked once.

Space Complexity: O(n)
- Space used for storing split words.

Pattern:
String Traversal / Character Checking
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        String input = "apple is orange umbrella cat";
        System.out.println(countWordsStartWithVowel(input));
    }

    static int countWordsStartWithVowel(String input) {

        String[] words = input.split(" ");
        int longestOdd = 0;
        int count = 0;

        for(String word : words){
            char ch = word.charAt(0);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count ++;
            }
        }

        return count;
    }
}
