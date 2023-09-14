import java.util.HashMap;

/*
Create a hashmap with target with index
loop through to check if (target-number) exists in the map
 */
public class TwoSum {
        public static void main(String[] args) {
                int[] result = twoSum(new int[]{2, 1, 3, 4}, 7);
                for (int num :
                        result) {
                        System.out.println(num);
                }
        }

        public static int[] twoSum(int[] nums, int target) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                        int diff = target - nums[i];
                        if (map.containsKey(diff)) {
                                return new int[]{map.get(diff), i};
                        }
                        map.put(nums[i], i);
                }
                return new int[]{};
        }
}
