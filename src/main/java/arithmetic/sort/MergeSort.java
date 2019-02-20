package arithmetic.sort;

/**
 * 
 * @ClassName: MergeSort
 * @Description:归并 排序 待排序列表 分成 若干个 子列表 - 每个子列表是有序的，再将自列表合并。
 * @author: 谢洪伟
 * @date: 2018年12月27日 下午4:51:34
 */
public class MergeSort {
	public static int[] sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(nums, low, mid); // 左
			sort(nums, mid + 1, high); // 右
			merge(nums, low, mid, high);
		}

		return nums;
	}

	/**
	 * 将数组排序
	 * 
	 * @param nums
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int[] nums, int low, int mid, int high) {
		// 1.新数组 2.左右指针 3.将较小的数移到数组 4.左边剩余移入数组5.右边剩余移入数组 6.覆盖原数组
		int[] temp = new int[nums.length];
		int i = low; // 左指针
		int j = mid + 1;// 右指针
		int k = 0;
		while (i < mid && j < high) {
			if (nums[i] < nums[j])
				temp[k++] = nums[i++];
			else
				temp[k++] = nums[j++];
		}

		if (i <= mid)
			temp[k++] = nums[i++];

		if (j <= high)
			temp[k++] = nums[j++];

		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}

	}
}
