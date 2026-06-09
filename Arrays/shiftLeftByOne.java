import java.util.Arrays;
public class practice {
    public static void main(String[] args) {
        int N = 5;
        int[] array = {1,2,3,4,5};
        int[] ans = shiftLeftByOne(array, N);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] shiftLeftByOne(int[] array, int N) {
        int temp = array[0];
        for(int i=1;i<N;i++){
            array[i-1] = array[i];
        }
        array[N-1] = temp;
        return array;
    }

}


