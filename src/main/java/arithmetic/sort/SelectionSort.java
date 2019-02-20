package arithmetic.sort;

/**
 * 
 * @ClassName: SelectionSort
 * @Description:选择排序
 * @author: 谢洪伟
 * @date: 2018年12月26日 下午3:52:36
 */
public class SelectionSort {
	Integer[] nums;

	public void sort() {
		int out, in, min;
		min = 0;

		for (out = 0; out < 100; out++) {
			min = out;
			for (in = out + 1; in < 100; in++) {
				if (nums[in] < min) { // 比较 n2
					min = in;
				}
			}

			nums[in] = nums[in] ^ min; // 这里交换 只有有 n
			min = nums[in] ^ min;
			nums[in] = nums[in] ^ min;

		}
	}
}
