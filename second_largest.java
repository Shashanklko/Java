public class second_largest {
    public static int firstLargest(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int SecondLargest(int[] arr, int n){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i<n;i++){
            if(arr[i]>max1){
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i]>max2 && arr[i]!=max1){
                max2 = arr[i];
            }
        }
        return max2;
    }
	
	
    public static void main(String[] args)
	{
		int arr[] = { 12, 35, 1, 10, 34, 1 };
		int n = arr.length;
		System.out.println(firstLargest(arr, n));
        System.out.println(SecondLargest(arr, n));
	}
}
