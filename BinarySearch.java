class BinarySearch {
        /*
        this works on sorted asc order
        adjusting the subarray to search
        start mid end
        if target is greater than mid -> start = mid + 1
        if target is less than mid -> end = mid - 1
        eventually you will reach the number
        everytime you cut half of the array, so log n complexity
         */
        public static void main(String[] args) {
                // input
                int[] numbers = {1, 2};
                int target = 2;

                int start = 0;
                int end = numbers.length - 1;
                int mid;
                int target_index = -1;

                while (start <= end) {
                        mid = start + (end - start) / 2;
                        if (target == numbers[mid]) {
                                target_index = mid;
                                break;
                        }
                        if (target < numbers[mid]) {
                                end = mid - 1;
                        } else {
                                start = mid + 1;
                        }
                }
                System.out.printf("target index is %d", target_index);
        }
}
