public class ValidPalindrome {
        public static void main(String[] args) {
                //input can contain non,alphanumeric
                boolean palindrome = isPalindrome(" apG0i4maAs::sA0m4i0Gp0");
                System.out.println(palindrome);
        }

        public static boolean isPalindrome(String s) {
                int left = 0, right = Math.max(s.length() - 1, 0);
                String s1 = s.toLowerCase();
                while (left != right) {
                        if (!Character.isLetterOrDigit(s1.charAt(left))) {
                                left += 1;
                                continue;
                        }
                        if (!Character.isLetterOrDigit(s1.charAt(right))) {
                                right -= 1;
                                continue;
                        }
                        if (s1.charAt(left) != s1.charAt(right)) {
                                return false;
                        }
                        left += 1;
                        right -= 1;
                }
                return true;
        }

}
