public class ProductExceptSelf {
        public static void main(String[] args) {
                int[] result = productExceptSelf(new int[]{1, 2, 3, 4});
                for (int num :
                        result) {
                        System.out.println(num);
                }
        }

        /*
        Bruteforce:
        two loops O(n^2) O(1)

        Prefix, Postfix arrays:
        two arrays O(n) O(n)

                public static int[] productExceptSelf(int[] nums) {
                int[] prefix = new int[nums.length];
                int[] postfix = new int[nums.length];
                int temp = 1;
                for (int i = 0; i < nums.length; i++) {
                        prefix[i] = temp;
                        temp = temp * nums[i];
                }
                temp = 1;
                for (int i = nums.length - 1; i >= 0; i--) {
                        postfix[i] = temp;
                        temp = temp * nums[i];
                }
                int[] result = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                        result[i] = prefix[i] * postfix[i];
                }
                return result;
        }
        Single array:
        O(n) O(1)
         */

        private static int[] productExceptSelf(int[] nums) {
                int[] result = new int[nums.length];
                int temp = 1;
                for (int i = 0; i < nums.length; i++) {
                        result[i] = temp;
                        temp = temp * nums[i];
                }
                temp = 1;
                for (int i = nums.length - 1; i >= 0; i--) {
                        result[i] = result[i] * temp;
                        temp = temp * nums[i];
                }
                return result;
        }

}
