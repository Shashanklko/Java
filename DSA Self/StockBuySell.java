// public class StockBuySell {

//     public static int maxProfit(int[] prices) {
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = 0;

//         for (int price : prices) {
//             if (price < minPrice) {
//                 minPrice = price;
//             } else {
//                 maxProfit = Math.max(maxProfit, price - minPrice);
//             }
//         }
//         return maxProfit;
//     }

//     public static void main(String[] args) {
//         int[] arr = {5, 4, 6, 8, 7, 9};
//         System.out.println(maxProfit(arr));
//     }
// }

public class StockBuySell {

    public static void maxProfitWithIndex(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int minIndex = 0;

        int maxProfit = 0;
        int buyIndex = 0;
        int sellIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minIndex = i;
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
                buyIndex = minIndex;
                sellIndex = i;
            }
        }

        System.out.println("Buy Index: " + buyIndex);
        System.out.println("Sell Index: " + sellIndex);
        System.out.println("Max Profit: " + maxProfit);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 8, 7, 9};
        maxProfitWithIndex(arr);
    }
}
