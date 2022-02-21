
public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(search(nums, 2, 0, nums.length));
    }

    private static int search(int[] nums, int target, int start, int end) {
        if(start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        if(target > nums[mid]) {
            return search(nums, target, mid + 1, end);
        }
        return search(nums, target, start, mid - 1);
    }
}
