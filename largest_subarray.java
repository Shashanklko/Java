public class largest_subarray {
    public static int sum(int[] arr){
        int currentsum = arr[0];
        int maxsum = arr[0];
        for(int i = 1;i<arr.length;i++){
            currentsum = Math.max(arr[i], currentsum+=arr[i]);
            maxsum = Math.max(currentsum, maxsum);
        }
        return maxsum;
    }
    public static void main(String[] args){
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(sum(arr));
    }
}
