import java.util.HashMap;

public class LongestAfterReplacing {
        public static void main(String[] args) {
                System.out.println(characterReplacement("AABABBA", 1));
        }

        /*
        sliding window algorithm O(n) + O(26)[to find the most frequent from the map]
        keep incrementing right of a window if number of elements to replace(total - most frequent) within k
        if it exceeds we need resize the window, left moves one step forward
         */

        public static int characterReplacement(String s, int k) {
                int maxLength = 0;
                int left = 0, right = 0;
                HashMap<Character, Integer> countMap = new HashMap<>();
                while (right < s.length()) {
                        char key = s.charAt(right);
                        Integer count = countMap.containsKey(key) ? countMap.get(key) + 1 : 1;
                        countMap.put(key, count);
                        int totalWindow = right - left + 1;
                        int mostFrequentCount = countMap.values().stream().max(Integer::compareTo).orElse(0);
                        int numberOfCharsToReplace = totalWindow - mostFrequentCount;
                        if (numberOfCharsToReplace > k) {
                                char keyToDecrement = s.charAt(left);
                                countMap.put(keyToDecrement, countMap.get(keyToDecrement) - 1);
                                left = left + 1;
                        } else {
                                maxLength = Math.max(maxLength, totalWindow);
                        }
                        right = right + 1;
                }
                return maxLength;
        }
}
