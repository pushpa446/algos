import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
        public static void main(String[] args) {
                List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
                result.forEach((triplet) -> {
                        System.out.println("----");
                        triplet.forEach(System.out::println);
                        System.out.println("----");
                });
        }

        /*
        pick element, and find target-element in rest of the array
        to avoid duplicate triplets, sort the array and once we find a solution, skip if its pre, current elements are same
        O(n^2)
         */

        public static List<List<Integer>> threeSum(int[] nums) {
                List<List<Integer>> result = new ArrayList<>();
                int targetSum = 0;
                Arrays.sort(nums);
                for (int i = 0; i < nums.length; i++) {
                        if (i != 0 && nums[i] == nums[i - 1]) {
                                continue;
                        }
                        int target = targetSum - nums[i];
                        int left = i + 1, right = nums.length - 1;
                        while (left < right) {
                                int sum = nums[left] + nums[right];
                                if (sum == target) {
                                        result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                                        left += 1;
                                        while(left < right && nums[left] == nums[left - 1]){
                                                left = left + 1;
                                        }
                                } else if (sum > target) {
                                        right -= 1;
                                } else {
                                        left += 1;
                                }
                        }
                }
                return result;
        }
}