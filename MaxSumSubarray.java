public class MaxSumSubarray {
        public static void main(String[] args) {
                System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        }

        /*
        brute force
        take all possible subarrays and compare o(n^2)
         */
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
}
