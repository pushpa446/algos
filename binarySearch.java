class BinarySearch {
	public static void main(String[] args) {
		// input
		int[] numbers = { 1, 2 };
		int target = 2;

		int start = 0;
		int end = numbers.length - 1;
		int mid = 0;
		int target_index = -1;

		while (start <= end) {
			mid = (start + end) / 2;
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
