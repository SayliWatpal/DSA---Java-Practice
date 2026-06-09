import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {8, 2, 4, 5, 3, 7, 1};

        int ans = missingNumber(array);
        if(ans == -1){
            System.out.println("All present");
        }
        else{
            System.out.println(ans);
        }
    }

    public static int missingNumber(int[] array) {
        int n = array.length + 1;
        for(int i=1;i<n;i++){
            boolean found = false;
            for(int j=0;j<n-1;j++){
                if(array[j] == i){
                    found = true;
                    break;
                }
            }
            if(!found){
                return i;
            }
        }
        return -1;
    }
}


