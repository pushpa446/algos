public class SortedSquares {
    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{-4, -1, 0, 2, 3}));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int start = 0, end = nums.length - 1, index = nums.length - 1;
        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                squares[index] = nums[start] * nums[start];
                start = start + 1;
            } else {
                squares[index] = nums[end] * nums[end];
                end = end - 1;
            }
            index = index - 1;
        }
        return squares;
    }
}
