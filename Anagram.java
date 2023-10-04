import java.util.HashMap;
import java.util.Map;

/*
if two strings of different length return false
sort strings and compare
count of characters in strings should match
 */
public class Anagram {
        public static void main(String[] args) {
                System.out.println(isAnagram("nagaram", "anagram"));
                System.out.println(isAnagram("rat", "cat"));
        }

        public static boolean isAnagram(String s, String t) {
                if (s.length() != t.length()) {
                        return false;
                }
                Map<Character, Integer> sCount = new HashMap<>();
                Map<Character, Integer> tCount = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                        char key = s.charAt(i);
                        int count = sCount.containsKey(key) ? sCount.get(key) + 1 : 1;
                        sCount.put(key, count);

                        key = t.charAt(i);
                        count = tCount.containsKey(key) ? tCount.get(key) + 1 : 1;
                        tCount.put(key, count);
                }
                for (Character key : sCount.keySet()) {
                        if (!tCount.containsKey(key) || !sCount.get(key).equals(tCount.get(key))) {
                                return false;
                        }
                }
                return true;
        }
}
