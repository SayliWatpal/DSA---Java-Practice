/*
Problem: Find Word with Highest Number of Vowels
Platform: Basic String Problem
Difficulty: Easy

Approach:
We are given a sentence containing multiple words.
The task is to find the word that contains
the highest number of vowels.

Vowels considered:
a, e, i, o, u

Steps:
1. Split the sentence into words using space (" ").
2. Initialize:
   - maxVowel = 0
   - ans = ""

3. Traverse through each word:
   - Count the number of vowels present in that word.
   - For every character:
       Check whether it is a vowel.

4. If the current word has more vowels than maxVowel:
   - Update maxVowel
   - Store the current word in ans

5. If multiple words have the same highest vowel count:
   - The latest word is stored because of
     the condition count >= maxVowel.

6. Return the final answer.

Example:
Input:
"java is easy"

Word-wise vowel count:
java -> 2
is   -> 1
easy -> 2

Both "java" and "easy" have 2 vowels,
but "easy" is returned because it appears later.

Output:
easy

Time Complexity: O(n)
- Every character of the string is visited once.

Space Complexity: O(n)
- Space used for storing split words.

Pattern:
String Traversal / Counting
*/
import java.util.*;

public class stock {
    public static void main(String[] args) {
        String input = "java is easy";
        System.out.println(highestNoOfVowel(input));
    }

    static String highestNoOfVowel(String input) {

        String[] words = input.split(" ");
        int maxVowel = 0;
        String ans = "";

        for(String word : words){
            int count = 0 ;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    count++;
                }
            }
            if(count >= maxVowel){
                maxVowel = count;
                ans = word;
            }
        }
        return ans;
    }
}
