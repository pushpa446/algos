public class ContainerWithWater {
        public static void main(String[] args) {
                int result = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
                System.out.println(result);
        }
        /*
        more area more water
        more area -> more height * more width
        so start with more width, which is 0 to last index
        max height = min(height[left], height[right])
        decrease left or right pointer based on min height
         */

        public static int maxArea(int[] height) {
                int left = 0, right = height.length - 1, maxContainer = 0;
                while (left < right) {
                        int width = right - left;
                        int length = Math.min(height[left], height[right]);
                        int area = width * length;
                        maxContainer = Math.max(maxContainer, area);
                        if (height[left] < height[right]) {
                                left += 1;
                        } else {
                                right -= 1;
                        }
                }
                return maxContainer;
        }
}
