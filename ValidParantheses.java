import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
        public static void main(String[] args) {
                System.out.println(isValid("[([]])"));
        }

        /*
        every close bracket should have a preceding open bracket
        if its open bracket add to list
        if its close bracket check if preceding(last element in the list) has matching open bracket, and remove this from consideration, if not return false
        at the end list should be empty indicating all brackets found its pair and got removed
        it not return false
         */

//        public static boolean isValid(String s) {
//                Map<Character, Character> paranthesesMap = Map.of(')', '(', '}', '{', ']', '[');
//                ArrayList<Character> chars = new ArrayList<>();
//                for (Character c :
//                        s.toCharArray()) {
//                        if (paranthesesMap.containsKey(c)) {
//                                if (chars.size() == 0 || chars.get(chars.size() - 1) != paranthesesMap.get(c)) {
//                                        return false;
//                                } else {
//                                        chars.remove(chars.size() - 1);
//                                }
//                        } else {
//                                chars.add(c);
//                        }
//                }
//                return chars.size() == 0;
//        }

        public static boolean isValid(String s) {
                Map<Character, Character> paranthesesMap = Map.of(')', '(', '}', '{', ']', '[');
                Stack<Character> chars = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (paranthesesMap.containsKey(c)) {
                                if (chars.size() == 0 || chars.peek() != paranthesesMap.get(c)) {
                                        return false;
                                } else {
                                        chars.pop();
                                }
                        } else {
                                chars.push(c);
                        }
                }

                return chars.size() == 0;
        }
}
