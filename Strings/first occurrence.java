/*
Problem no.: 28
Problem: Find the Index of the First Occurrence in a String (strStr)
Platform: LeetCode
Difficulty: Easy

Approach:
We are given two strings: haystack (main string) and needle (substring to find).
The goal is to return the starting index of the first occurrence of needle
in haystack. If needle is not found, return -1.

To solve this, we use a brute-force sliding window approach.
We try to match the needle starting from every possible index in the haystack.

Since the needle has length m, we only need to check till index (n - m),
because beyond that there won’t be enough characters left to match.

For each starting index i:
1. Initialize a pointer j = 0 for the needle.
2. Compare characters of haystack and needle one by one:
   haystack[i + j] with needle[j]
3. Continue until characters match or j reaches m.
4. If j == m, it means the entire needle has been matched,
   so we return the current index i.

If no match is found after checking all valid positions,
we return -1.

Time Complexity: O(n × m)
Space Complexity: O(1)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i=0;i<=n-m;i++){
            int j = 0;

            while(j<m && haystack.charAt(i+j) == needle.charAt(j)){

                j++;
            }

            if(j == m){
                return i;
            }
        }
        return -1;
    }
}

