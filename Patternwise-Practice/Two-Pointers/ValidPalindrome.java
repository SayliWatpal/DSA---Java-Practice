/*
Problem no.: 125
Problem: Valid Palindrome
Platform: LeetCode
Difficulty: Easy

Approach:
The string may contain spaces, punctuation marks, and mixed case letters.
According to the problem, we must ignore all non-alphanumeric characters
and compare the remaining characters in a case-insensitive manner.

First convert the string to lowercase so that uppercase and lowercase
letters are treated the same.

Then use the Two Pointer technique:
- Pointer i starts from the beginning of the string.
- Pointer j starts from the end of the string.

While i < j:
1. If the character at i is not a letter or digit, move i forward.
2. If the character at j is not a letter or digit, move j backward.
3. If both characters are valid, compare them.
   If they are different, the string is not a palindrome.
4. If they are equal, move both pointers towards the center.

If the loop completes without mismatches, the string is a palindrome.

Time Complexity: O(n)
Space Complexity: O(1)

Pattern: Two Pointers
*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i<j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(!Character.isLetterOrDigit(c1)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(c2)){
                j--;
                continue;
            }
            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
