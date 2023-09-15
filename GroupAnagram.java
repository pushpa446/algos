import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
        public static void main(String[] args) {
                System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

        }

        public static List<List<String>> groupAnagrams(String[] strs) {
                HashMap<String, List<String>> map = new HashMap<>();
                for (String string :
                        strs) {
                        char[] chars = string.toCharArray();
                        Arrays.sort(chars);
                        String sortedString = Arrays.toString(chars);
                        if(map.containsKey(sortedString)){
                                List<String> strings = map.get(sortedString);
                                strings.add(string);
                        } else {
                                map.put(sortedString, new ArrayList<>(Arrays.asList(string)));
                        }
                }
                return map.values().stream().toList();

        }
}
