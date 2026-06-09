import java.util.Arrays;
public class practice {
    public static void main(String[] args) {
        int N = 6;
        int[] array = {1,4,5,2,0,0};
        int[] ans = moveZeros(array, N);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] moveZeros(int[] array, int N) {
        int j = -1;

        for(int k=0;k<N;k++) {
            if (array[k] == 0) {
                j = k;
                break;
            }
        }
        if(j == -1) return array;
        for(int i=j+1;i<N;i++){
            if(array[i] != 0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
        return array;
    }

}


