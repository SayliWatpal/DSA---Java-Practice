/*
Problem: Sum of Factors of a Number
Platform: Basic DSA / Math Problem
Difficulty: Easy

Approach:
We are given a number n.
The task is to calculate the sum of all factors of n.

A factor is a number that divides n completely without leaving a remainder.

Steps:
1. Initialize a variable sum = 0.
2. Traverse from 1 to n.
3. For every number i:
   - Check if n % i == 0
   - If true, i is a factor of n.
4. Add the factor to sum.
5. After the loop ends, return the total sum.

Example:
n = 10

Factors of 10 = [1, 2, 5, 10]

Sum = 1 + 2 + 5 + 10
     = 18

Output = 18

Time Complexity: O(n)
- We iterate from 1 to n once.

Space Complexity: O(1)
- No extra space is used except variables.

Pattern:
Factorization / Mathematical Computation
*/

import java.util.*;

public class stock {
    public static void main(String[] args) {
        int n = 10;
        int ans = sumOfFactor(n);
        System.out.println(ans);
    }

    static int sumOfFactor(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
