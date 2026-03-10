/*
Problem: Multiply Strings
Platform: LeetCode
Difficulty: Medium

Approach:
The numbers are given as strings, so they cannot be directly converted to integers
because the values may exceed the integer limit.

To solve this, we simulate the normal multiplication process done by hand.
Each digit of num1 is multiplied with each digit of num2 starting from the
rightmost digits.

The result of each multiplication is placed in an integer array of size (n + m)
because the maximum possible length of the product of two numbers with lengths
n and m is n + m.

For every pair of digits:
1. Multiply the digits.
2. Add the product to the correct position in the result array.
3. Handle carry by distributing it between two positions.

After completing all multiplications, we traverse the result array and build
the final string while skipping leading zeros.

Time Complexity: O(n × m)
Space Complexity: O(n + m)
*/

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length();
        int m = num2.length();
        if(n == 0 || m == 0) return "0";
        

        int[] ans = new int [n+m];

        for(int i=n-1 ;i>=0; i--){
            for(int j=m-1; j>=0;j--){
                int digit1 = num1.charAt(i)-'0';
                int digit2 = num2.charAt(j)-'0';
                int product = digit1 * digit2;
                int p1 = i+j;
                int p2 = i+j+1;

                int sum = product + ans[p2];
                ans[p1] += sum/10;
                ans[p2] = sum%10;

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int nums : ans){
            if(sb.length() == 0 && nums == 0){
                continue;
            }
            sb.append(nums);
        }
        return sb.toString();
    }
}
