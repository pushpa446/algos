public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 8}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        if (target < nums[start]) {
            return 0;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
