public class Rainwater{
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int l = 0 , r = n-1;
        int lmax = 0, rmax = 0;

        while(l<r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if(lmax<rmax){
                water += lmax - height[l];
                l++;
            }else{
                water += rmax - height[r];
                r--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {3, 0, 2, 0, 4};

        int result = trap(height);
        System.out.println(result);
    }
}


// (Suffix -prefix) Precomputation Approach
        // int lbar[] = new int[n];
        // int rbar[] = new int[n];
        // lbar[0] = height[0];
        // rbar[n-1] = height[n-1];

        // for(int i = 1, j = n-2 ;i<n;i++,j--){
        //     lbar[i] = Math.max(lbar[i-1],height[i]);
        //     rbar[j] = Math.max(rbar[j+1],height[j]);
        // }
        // for(int i = 0 ;i<n;i++){
        //     water += Math.min(lbar[i],rbar[i]) - height[i];
        // }
        // return water;