/*
Problem: Sort an array containing only 0s, 1s, and 2s.

Approach:
1. Traverse the array once and count the number of 0s, 1s, and 2s.
2. Overwrite the original array:
   - Place all 0s first.
   - Then place all 1s.
   - Finally place all 2s.
3. Return the sorted array.

Time Complexity: O(n)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {1, 0, 2, 1, 0} ;

        int[] ans = sortArray(array);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] sortArray(int[] array) {
        int n = array.length;
        int countz = 0;
        int counto = 0;
        int countt = 0;

        for(int i=0;i<n;i++){
            if(array[i] == 0){
                countz++;
            }
            else if(array[i] == 1){
                counto++;
            }
            else{
                countt++;
            }
        }
        int index = 0;
        while(countz > 0){
            array[index] = 0;
            index++;
            countz--;
        }
        while(counto > 0){
            array[index] = 1;
            index++;
            counto--;
        }
        while(countt > 0){
            array[index] = 2;
            index++;
            countt--;
        }
        return array;
    }
}

/*
Problem: Sort an array containing only 0s, 1s, and 2s.

Approach (Dutch National Flag Algorithm):

- Maintain three pointers:
  low  -> boundary for 0s
  mid  -> current element being processed
  high -> boundary for 2s

- Traverse the array while mid <= high.

1. If array[mid] == 0:
   - Swap array[mid] with array[low].
   - Increment both low and mid.

2. If array[mid] == 1:
   - It is already in the correct position.
   - Increment mid.

3. If array[mid] == 2:
   - Swap array[mid] with array[high].
   - Decrement high.
   - Do not increment mid because the swapped element at mid
     has not been processed yet.

After the traversal, all 0s are placed at the beginning,
1s in the middle, and 2s at the end.

Time Complexity: O(n)
Space Complexity: O(1)
*/


import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {1, 0, 2, 1, 0} ;

        int[] ans = sortArray(array);
        System.out.println(Arrays.toString(ans));
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static int[] sortArray(int[] array) {
        int n = array.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid<=high){
            if(array[mid] == 0){
                swap(array,mid,low);
                low++;
                mid++;
            }
            else if(array[mid] == 1){
                mid++;
            }
            else{
                swap(array,mid,high);
                high--;
            }
        }

        return array;
    }
}






