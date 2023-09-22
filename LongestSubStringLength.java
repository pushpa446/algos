import java.util.HashSet;

public class LongestSubStringLength {

        public static void main(String[] args) {
                int result = lengthOfLongestSubstring("abcabcbb");
                System.out.println(result);
        }

        /*
        abcabcbb
        traverse through the chars, keep adding to hashset
        if a character exists already, remove the char from hashset and move the left pointer until the characters is not duplicated

         */
        public static int lengthOfLongestSubstring(String s) {
                int maxLength = 0;
                int left = 0, right = 0;
                HashSet<Character> characters = new HashSet<>();
                while (right < s.length()) {
                        while (characters.contains(s.charAt(right))) {
                                characters.remove(s.charAt(left));
                                left = left + 1;
                        }
                        characters.add(s.charAt(right));
                        int subStringLength = right - left + 1;
                        if (subStringLength > maxLength) maxLength = subStringLength;
                        right = right + 1;
                }

                return maxLength;
        }
}