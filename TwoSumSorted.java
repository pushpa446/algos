import java.util.HashMap;

/*
Brute force:
loop through each combination till sum is greater than target
worst case: O(n^2)

start from left and right most
increase left pointer if sum < target
decrease right pointer if sum > target

O(n)
 */
public class TwoSumSorted {
        public static void main(String[] args) {
                int[] result = twoSum(new int[]{1, 2, 3, 4}, 7);
                for (int num :
                        result) {
                        System.out.println(num);
                }
        }

        public static int[] twoSum(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                while (left != right){
                        if(nums[left] + nums[right] == target){
                                return new int[]{left+1,right+1};
                        } else if(nums[left] + nums[right] > target){
                                right = right -1;
                        } else {
                                left = left + 1;
                        }
                }
                return new int[]{};
        }
}
