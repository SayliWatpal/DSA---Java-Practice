/*
Problem: Find P-th Factor of a Number
Difficulty: Easy

Approach:
We are given a number n and an integer p.
The task is to find the factor present at the p-th position
when all factors of n are arranged in increasing order.

A factor is a number that divides n completely without leaving a remainder.

Steps:
1. Create an ArrayList to store all factors of n.
2. Traverse from 1 to n.
3. For every number i:
   - Check if n % i == 0
   - If true, i is a factor of n, so add it to the list.
4. After collecting all factors:
   - Access the factor at index (p - 1)
     because ArrayList uses 0-based indexing.
5. Return that factor.

Example:
n = 12
Factors = [1, 2, 3, 4, 6, 12]

If p = 3
Answer = 3

Time Complexity: O(n)
- We iterate from 1 to n once.

Space Complexity: O(k)
- k = total number of factors stored in the list.

Pattern:
Factorization / ArrayList Storage
*/

import java.util.*;
public class stock { 
  public static void main(String[] args) { 
    int n = 12; 
    int p = 3; 
    int ansAtp = countFactor(n,p);
    System.out.println("Factor at " + p + " index: " + ansAtp);
  } 
  static int countFactor(int n,int p) { 
    List<Integer> factors = new ArrayList<>();
    for(int i=1;i<=n;i++) { 
      if (n % i == 0) { 
        factors.add(i);
      } 
    } 
    int ans = factors.get(p-1); 
    return ans;
  }
}
