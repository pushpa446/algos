import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
        public static void main(String[] args) {
                System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

        }
/*
sort each string ,if already exists append to the list else add it to map
Time complexity O(n * mlogm)
Space complexity O(n)
 */
        public static List<List<String>> groupAnagrams(String[] strs) {
                HashMap<String, List<String>> map = new HashMap<>();
                for (String string :
                        strs) {
                        char[] chars = string.toCharArray();
                        Arrays.sort(chars);
                        String sortedString = Arrays.toString(chars);
                        if(!map.containsKey(sortedString)){
                                map.put(sortedString, new ArrayList<>());
                        }
                        map.get(sortedString).add(string);
                }
                return new ArrayList<>(map.values());
        }
}
