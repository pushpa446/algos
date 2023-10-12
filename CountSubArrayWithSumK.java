import java.util.HashMap;
import java.util.List;

public class CountSubArrayWithSumK {
        public static void main(String[] args) {
                System.out.println(countNumberOfSubarrays(List.of(5, 10, 2, -2, -20, 10), -10));
        }

        public static long countNumberOfSubarrays(List<Integer> arr, int k) {
                HashMap<Integer, Integer> prefixSum = new HashMap<>();
                prefixSum.put(0, 1);
                Integer sum = 0;
                long count = 0;

                for (Integer current : arr) {
                        sum += current;
                        if (prefixSum.containsKey(sum - k)) {
                                count = count + prefixSum.get(sum - k);
                        }
                        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
                }
                return count;
        }
}
