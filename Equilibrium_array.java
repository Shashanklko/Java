public class Equilibrium_array {
  public static int equilibrium_array(int[] arr){
    int n = arr.length;
    int sum =0;
    int leftsum = 0;
    for(int i = 0; i<n;i++){
        sum += arr[i];
    }
    for(int i = 0;i<n;i++){
        sum -= arr[i];
        if(sum==leftsum){
            return i;
        }
        leftsum +=arr[i];
    } return -1;
  }

  public static void main(String[] args){
    int[] arr = {-7, 1, 5, 2, -4, 3, 0};
    System.out.println(equilibrium_array(arr));
  } 
}
