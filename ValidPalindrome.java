public class ValidPalindrome {
        public static void main(String[] args) {
                //input can contain non,alphanumeric
                boolean palindrome = isPalindrome(" apG0i4maAs::sA0m4i0Gp0");
                System.out.println(palindrome);
        }

        public static boolean isPalindrome(String s) {
                int left = 0, right = Math.max(s.length() - 1, 0);
                while (left < right) {
                        if (!Character.isLetterOrDigit(s.charAt(left))) {
                                left += 1;
                                continue;
                        }
                        if (!Character.isLetterOrDigit(s.charAt(right))) {
                                right -= 1;
                                continue;
                        }
                        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                                return false;
                        }
                        left += 1;
                        right -= 1;
                }
                return true;
        }

}
