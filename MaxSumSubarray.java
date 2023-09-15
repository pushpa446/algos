public class MaxSumSubarray {
        public static void main(String[] args) {
                System.out.println(maxSubArray(new int[]{-2, -3, -1, -4, -5}));
        }

        /*
        brute force
        take all possible subarrays and compare o(n^2)

        public static int maxSubArray(int[] nums) {
                int maxSum = nums[0];
                for (int i = 0; i < nums.length; i++) {
                        int currentSum = 0;
                        for (int j = i; j < nums.length; j++) {
                                currentSum += nums[j];
                                if (currentSum > maxSum) {
                                        maxSum = currentSum;
                                }
                        }
                }
                return maxSum;
        }
         */

        /*
        if sum so far is negative it does not contribute to the largest sum, so eliminate that subarray
         */
        public static int maxSubArray(int[] nums) {
                int maxSum = nums[0];
                int currentSum = 0;
                for (int num : nums) {
                        if(num > currentSum + num ){
                                currentSum = num;
                        } else {
                                currentSum += num;
                        }
                        if (currentSum > maxSum) {
                                maxSum = currentSum;
                        }
                }
                return maxSum;
        }
}
