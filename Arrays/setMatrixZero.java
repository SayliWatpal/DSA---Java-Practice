/*
Problem: Set Matrix Zeroes
Platform: LeetCode (Variation)
Difficulty: Medium

Approach:
The idea is to convert all rows and columns to zero wherever a 0 is found in the matrix.
Instead of using extra space, we use a marking technique with -1 to avoid immediately overwriting values.

We scan the matrix and whenever we find a 0:
- We mark all non-zero elements in its row as -1
- We mark all non-zero elements in its column as -1

This ensures that:
- Original 0s remain unchanged during traversal
- Newly affected cells are temporarily marked and not confused with original 0s

After the marking process is complete, we do a second pass:
- Convert all -1 values to 0

This gives the final matrix where entire rows and columns containing at least one 0 are set to zero.

Time Complexity: O(m * n * (m + n))
Space Complexity: O(1)
*/


import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[][] array = {{1,1,1},{1,0,1},{1,1,1}};
        setMatrixZero(array);
        for (int[] row : array) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZero(int[][] array) {
        int m = array.length; // row
        int n = array[0].length; // column
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(array[i][j] == 0){
                    //row
                    for(int col=0;col<n;col++){
                        if(array[i][col] != 0){
                            array[i][col] = -1;
                        }
                    }
                    //column
                    for(int row=0;row<m;row++){
                        if(array[row][j] != 0){
                            array[row][j] = -1;
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(array[i][j] == -1){
                    array[i][j] = 0;
                }
            }
        }
    }
}


/*
Problem: Set Matrix Zeroes
Platform: LeetCode 73
Difficulty: Medium

Approach:
We use extra space (boolean arrays) to track which rows and columns must be converted to zero.

Instead of modifying the matrix immediately (which can cause incorrect propagation), we first record all rows and columns that contain at least one zero.

We maintain:
- rowFlag[] → marks rows that contain a zero
- colFlag[] → marks columns that contain a zero

Step-by-step:
1. Traverse the entire matrix.
   - If matrix[i][j] == 0:
        → mark rowFlag[i] = true
        → mark colFlag[j] = true

2. Traverse the matrix again.
   - If rowFlag[i] is true OR colFlag[j] is true:
        → set matrix[i][j] = 0

3. Return the modified matrix.

Why this works:
- We separate "detection" and "modification"
- So original information is not corrupted during processing

Time Complexity: O(m * n)
Space Complexity: O(m + n)
*/


import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[][] array = {{1,1,1},{1,0,1},{1,1,1}};

        int[][] ans = setMatrixZero(array);

        for(int[] row : ans){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] setMatrixZero(int[][] array) {
        int m = array.length; // row
        int n = array[0].length; // column
        boolean[] rowFlag = new boolean[m];
        boolean[] colFlag = new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(array[i][j] == 0){
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowFlag[i] || colFlag[j]){
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}


