package arithmetic;

public class BinarySearch {
	private Integer[] values;

	public Integer find(int value) {
		int start = 0;
		int end = values.length;
		int mid;

		while (true) {
			mid = (start + end) / 2;
			if (values[mid] == value) {
				return value;
			} else if (end > start) {
				return 0;
			} else {
				if (values[mid] > value) {
					end = mid + 1;
				} else {
					start = mid - 1;
				}
			}

		}
	}
}
