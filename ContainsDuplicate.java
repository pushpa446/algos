import java.util.HashSet;

public class ContainsDuplicate {
        public static void main(String[] args) {
                System.out.println(containsDuplicate(new int[]{1, 2, 3, 1, 4}));
        }

        /*
        Bruteforce:
        Compare each element with every other element in the array
        O(n^2)

        Sort and compare each element with next element
        O(nlogn)for sorting + O(n) = O(nlogn)

        Use hashmap to store and check if already exists
        O(n) extra space complexity also O(n)
         */
        public static boolean containsDuplicate(int[] nums) {
                HashSet<Integer> numbers = new HashSet<>();
                for (int num :
                        nums) {
                        if (numbers.contains(num)) {
                                return true;
                        }
                        numbers.add(num);
                }
                return false;
        }
}
