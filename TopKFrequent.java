import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
        public static void main(String[] args) {
                int[] result = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
                for (int num :
                        result) {
                        System.out.println(num);
                }
        }
        /*
        add element to hashmap, then sort map by count, then return k elements
        Time complexity : O(n) + O(nlogn) + O(n)
        Space complexity: O(n)
         */

        public static int[] topKFrequent(int[] nums, int k) {
                HashMap<Integer, Integer> countMap = new HashMap<>();
                for (int number :
                        nums) {
                        int totalCount = countMap.containsKey(number) ? countMap.get(number) + 1 : 1;
                        countMap.put(number, totalCount);
                }
                return countMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).mapToInt(Map.Entry::getKey).toArray();
        }
}
