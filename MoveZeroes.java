import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] == 0) {
                int counter = index;
                // move zero to the right most non-zero value index
                while (counter < nums.length - 1 && nums[counter + 1] != 0) {
                    int temp = nums[counter];
                    nums[counter] = nums[counter + 1];
                    nums[counter + 1] = temp;
                    counter = counter + 1;
                }
            }
            index = index - 1;
        }
    }

}
