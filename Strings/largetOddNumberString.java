/*
Problem: Largest Odd Number in String
Platform: LeetCode 1903
Difficulty: Easy

Approach:
The idea is based on the fact that a number is odd if and only if its last
digit is odd. To obtain the largest odd-number substring, we need to find
the rightmost odd digit in the string and return the substring from the
beginning up to that digit.

Step-by-step:
1. Traverse the string from the last character towards the first.
2. For each character:
      → Convert it to an integer digit.
      → Check if the digit is odd.
3. As soon as the first odd digit is found:
      → Return the substring from index 0 to the current index (inclusive).
4. If no odd digit is found after traversing the entire string:
      → Return an empty string.

This works because:
- Any substring ending at an even digit is an even number.
- The rightmost odd digit gives the longest possible prefix that forms an
  odd number, which is also the largest-valued odd substring.

Time Complexity: O(n)
Space Complexity: O(1)
*/


import java.util.*;

public class practice {
    public static void main(String[] args) {
        String s = "5347";
        System.out.println(largetOddNumberString(s));
    }

    public static String largetOddNumberString(String s) {
        int index = -1;
        for(int i=s.length()-1;i>=0;i--) {
            if ((s.charAt(i) - '0') % 2 != 0){
                index = i;
                break;
            }
        }
        if(index == -1) return "";
        return s.substring(0,index+1);
    }
}


