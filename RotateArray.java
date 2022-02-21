import java.util.Arrays;

class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        /*
        say there is numbers with length 5, and k is 12,
        if we rotate the array 5 times the resultant array is original array
        so we don't need to rotate array 12 times, we can eliminate multiples of 5
        this is equivalent to rotating the array 2 times
        remainder of 12/5
        */
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start = start + 1;
            end = end - 1;
        }
    }
}
