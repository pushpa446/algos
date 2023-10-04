import java.util.HashMap;

//TODO: Fix the code
public class MinimumWindowSubstring {
        public static void main(String[] args) {
                String result = minWindow("bba", "ab");
                System.out.println("------result---------");
                System.out.println(result);
        }

        /*
        Brute force
        each substring,
        maintain count of target characters in a map
        maintain count of occurrence of target characters in subString in another map
        if both maps have matchingCounts thats our result

        public static String minWindow(String s, String t) {
                HashMap<Character, Integer> targetCountMap = new HashMap<>();
                int resultLeft = -1, resultRight = -1;
                for (int i = 0; i < t.length(); i++) {
                        char key = t.charAt(i);
                        int count = targetCountMap.containsKey(key) ? targetCountMap.get(key) + 1 : 1;
                        targetCountMap.put(key, count);
                }
                for (int i = 0; i < s.length(); i++) {
                        HashMap<Character, Integer> subStringMap = new HashMap<>();
                        int matchCount = 0;
                        for (int j = i; j < s.length(); j++) {
                                char key = s.charAt(j);
                                if (!targetCountMap.containsKey(key)) {
                                        continue;
                                }
                                int count = subStringMap.containsKey(key) ? subStringMap.get(key) + 1 : 1;
                                subStringMap.put(key, count);
                                if (targetCountMap.get(key) == count) {
                                        matchCount += 1;
                                        if (matchCount == targetCountMap.size()) {
                                                if ((resultRight == -1 && resultLeft == -1) || (j - i + 1) < (resultRight - resultLeft + 1)) {
                                                        resultLeft = i;
                                                        resultRight = j;
                                                }
                                                break;
                                        }
                                }
                        }
                }
                if (resultLeft == -1 && resultRight == -1) {
                        return "";
                }
                return s.substring(resultLeft, resultRight + 1);
        }
         */

        public static String minWindow(String s, String t) {
                if (s.length() < t.length()) {
                        return "";
                }
                // prepare target map
                HashMap<Character, Integer> targetCountMap = new HashMap<>();
                for (char key : t.toCharArray()) {
                        int count = targetCountMap.containsKey(key) ? targetCountMap.get(key) + 1 : 1;
                        targetCountMap.put(key, count);
                }

                int left = 0, right = 0, matchCount = 0, resultLeft = -1, resultRight = -1;
                HashMap<Character, Integer> subStringMap = new HashMap<>();
                while (left <= right && right < s.length()) {
                        while (right < s.length() && !targetCountMap.containsKey(s.charAt(right))) {
                                right = right + 1;
                        }
                        if(right >= s.length()){
                                break;
                        }
                        char key = s.charAt(right);
                        int count = subStringMap.containsKey(key) ? subStringMap.get(key) + 1 : 1;
                        subStringMap.put(key, count);
                        if (count == targetCountMap.get(key)) {
                                matchCount += 1;
                                if (matchCount == targetCountMap.size()) {
                                        System.out.println(s.substring(left, right + 1));
                                        if ((resultRight == -1 && resultLeft == -1) || (right - left + 1) < (resultRight - resultLeft + 1)) {
                                                resultLeft = left;
                                                resultRight = right;
                                        }
                                        subStringMap.put(s.charAt(left), subStringMap.get(s.charAt(left)) - 1);
                                        matchCount -= 1;
                                        left = left + 1;
                                        while (left < right && !targetCountMap.containsKey(s.charAt(left))) {
                                                left = left + 1;
                                        }
                                }
                        }
                        right = right + 1;
                }

                if (resultLeft == -1 && resultRight == -1) {
                        return "";
                }
                return s.substring(resultLeft, resultRight + 1);
        }
}
