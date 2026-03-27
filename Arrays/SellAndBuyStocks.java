/*
Problem no.: 121
Problem: Best Time to Buy and Sell Stock
Platform: LeetCode
Difficulty: Easy

Approach:
The idea is to find the maximum profit by making only one transaction.
We traverse the array once while keeping track of the minimum price seen so far.
For each day, we calculate the profit by subtracting the minimum price from the current price.
If this profit is greater than the current maximum profit, we update it.
If the current price is smaller than the minimum price, we update the minimum price.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class stock {
    public static void main(String[] args) {
        int[] arr = {10,7,5,8,11,9};
        int ans = stockSellBuy(arr);
        System.out.println(ans);
    }
    static int stockSellBuy(int[] arr){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min) {
                min = arr[i];
            }
            else{
                int profit = arr[i] - min;
                max = Math.max(max,profit);
            }
        }
        return max;

    }
}
