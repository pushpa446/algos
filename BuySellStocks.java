public class BuySellStocks {
        public static void main(String[] args) {
                int result = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
                System.out.println(result);
        }

        /*
        O(n^2)

        public static int maxProfit(int[] prices) {
                int profit = 0;
                for(int i=0;i<prices.length -1; i++){
                        for(int j=i+1; j< prices.length; j++){
                                profit = Math.max(prices[j] - prices[i], profit);
                        }
                }

                return profit;
        }

         */

        /*
        buy low sell high -> maximizes profit

        initialize left = 0, right = 1;
        keep moving right pointer till end
        move the left pointer only when right price is lesser than left
        track the maxprofit
         */
        public static int maxProfit(int[] prices) {
                int left = 0, right = 1, profit = 0;
                while (right < prices.length) {
                        if (prices[right] < prices[left]) {
                                left = right;
                        } else {
                                int current = prices[right] - prices[left];
                                if (profit < current) {
                                        profit = current;
                                }
                        }
                        right = right + 1;
                }
                return profit;
        }

}
