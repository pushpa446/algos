public class SearchRotatedSortedArray {
        public static void main(String[] args) {
                System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        }
        /*
        there are two parts sorted and unsorted array
        if you are on sorted array,
                if target is less than mid and greater than/equals left most, then move right to mid-1, else left to mid+1
        if you are on unsorted array,
                if target is greater than mid and less than/equals right most, then move left to mid + 1, else right to mid-1
         */

        public static int search(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] == target) {
                                return mid;
                        }
                        if (nums[left] <= nums[mid]) {
                                if (nums[left] <= target && target < nums[mid]) {
                                        right = mid - 1;
                                } else {
                                        left = mid + 1;
                                }
                        } else {
                                if (nums[mid] < target && target <= nums[right]) {
                                        left = mid + 1;
                                } else {
                                        right = mid - 1;
                                }
                        }
                }
                return -1;
        }
}
