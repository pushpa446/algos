public class MinOfRotatedSortedArray {
        public static void main(String[] args) {
                System.out.println(findMin(new int[]{3, 1, 2}));
        }

        /*
        if its sorted array first element will be the minimum
        if this array is rotated this first element moves, after n rotations original order comes
        we can divide the array into sorted and unsorted, our solution always lies in unsorted array
        so pick mid element, see whether it is greater than left most element or not, if yes move left to mid + 1, if not move right to mid - 1
        at first element, left element is greater than right, everywhereelse right elements are greater
         */

        public static int findMin(int[] nums) {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                        if (nums[left] <= nums[right]) {
                                return nums[left];
                        }

                        int mid = (left + right) / 2;
                        if (nums[left] <= nums[mid]) {
                                left = mid + 1;
                        } else {
                                right = mid;
                        }
                }
                return -1;
        }
}
