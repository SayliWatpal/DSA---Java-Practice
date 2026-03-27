
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
