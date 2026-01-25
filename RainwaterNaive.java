public class RainwaterNaive {

    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;

        for (int i = 0; i < n; i++) {
            int lbar = 0, rbar = 0;

            
            for (int l = 0; l <= i; l++) {
                lbar = Math.max(lbar, height[l]);
            }

            
            for (int r = i; r < n; r++) {
                rbar = Math.max(rbar, height[r]);
            }

            water += Math.min(lbar, rbar) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = {3, 0, 2, 0, 4};

        int result = trap(height);
        System.out.println(result);
    }
}


