/*
Problem no.: 151
Problem: Reverse Words in a String
Platform: LeetCode
Difficulty: Medium

Approach:
The idea is to reverse the order of words in the given string.

First, the string is split into words using space as a delimiter.
We use " +" in split to handle multiple spaces between words.

Then, we traverse the array of words from the end to the beginning.
Each word is appended to a StringBuilder followed by a space.

Finally, we trim the result to remove any extra space at the end.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        String s = "welcome to the jungle";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String s){
        String[] words = s.split(" +"); // splitting string based on whitespaces and handles multiple whitespaces
        StringBuilder sb = new StringBuilder();
        for(int i=words.length - 1;i>=0;i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
