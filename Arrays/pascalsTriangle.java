/*
Problem: Pascal's Triangle
Platform: LeetCode 118
Difficulty: Easy

Approach:
The idea is to build Pascal's Triangle row by row.
The first row always contains a single element [1]. Every subsequent row is
constructed using the previous row.

For each new row:
- The first and last elements are always 1.
- Every middle element is obtained by adding the two adjacent elements from
  the previous row.

Step-by-step:
1. Create a list 'result' to store all the rows of Pascal's Triangle.
2. If N == 0, return an empty list.
3. Add the first row [1] to the result.
4. For each row from index 1 to N-1:
      → Retrieve the previous row from the result.
      → Create a new row and add 1 as the first element.
      → Traverse the previous row and add the sum of every two adjacent
        elements to the current row.
      → Add 1 as the last element.
      → Store the completed row in the result.
5. After generating all rows, return the result.

Time Complexity: O(N²)
Space Complexity: O(N²)
*/


import javax.swing.*;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        List<List<Integer>> ans = pascalsTriangle(6);
        for(List<Integer> r : ans){
            System.out.println(r);
        }
    }

    public static List<List<Integer>> pascalsTriangle(int N) {
        List<List<Integer>> result = new ArrayList<>();

        if(N == 0) return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if(N == 1) return result;

        for(int i=1;i<N;i++){
            List<Integer> prevRow = result.get(i - 1);

            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=0;j<i-1;j++){
                row.add(prevRow.get(j) + prevRow.get(j+1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}


