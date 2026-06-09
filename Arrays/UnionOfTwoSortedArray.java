import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {2,3,4,4,5};
        System.out.println(unionOfTwoSortedArray(array1,array2));
    }

    public static Set<Integer> unionOfTwoSortedArray(int[] array1,int[] array2) {
        int n = array1.length;
        int m = array2.length;
        Set<Integer> merge = new HashSet<>();
        for(int i=0;i<n;i++){
            merge.add(array1[i]);
        }
        for(int i=0;i<m;i++){
            merge.add(array2[i]);
        }

        return merge;
    }
}


