import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
        public static void main(String[] args) {
                int result = longestConsecutive(new int[]{100, 2, 3, 4, 200});
                System.out.println(result);
        }

        /*
        maintain hash set
        sequence starts when element-1 doesnt exist
        once sequence starts, loop it until you find next element
         */
        public static int longestConsecutive(int[] nums) {
                Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
                int maxSequenceLength = 0;

                for (int num : nums) {
                        if (!set.contains(num - 1)) {
                                //sequence starts since no left element
                                int sequenceLength = 1;
                                int temp = num + 1;
                                while (set.contains(temp)) {
                                        sequenceLength += 1;
                                        temp += 1;
                                }
                                if (sequenceLength > maxSequenceLength) {
                                        maxSequenceLength = sequenceLength;
                                }
                        }
                }
                return maxSequenceLength;
        }
}
