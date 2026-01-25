import java.util.Scanner;

class sum_of_subarray {

    public static int sum_subarray(int[] prefix, int l, int r) {
        if (l == 0) {
            return prefix[r];
        } else {
            return prefix[r] - prefix[l - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int arr_size = sc.nextInt();

        int[] arr = new int[arr_size];
        System.out.print("Enter " + arr_size + " elements: ");
        for (int i = 0; i < arr_size; i++) {
            arr[i] = sc.nextInt();
        }

        // Prefix sum
        int[] prefix = new int[arr_size];
        prefix[0] = arr[0];
        for (int i = 1; i < arr_size; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter queries (l r):");
        while (q-- > 0) {

            int l, r;

            // keep asking until valid
            while (true) {
                l = sc.nextInt();
                r = sc.nextInt();

                if (l >= 0 && r < arr_size && l <= r) {
                    break; // valid input
                } else {
                    System.out.println("Invalid range. Please enter again:");
                }
            }

            int sum = sum_subarray(prefix, l, r);
            System.out.println("Sum from index " + l + " to " + r + " = " + sum);
        }

        sc.close();
    }
}
