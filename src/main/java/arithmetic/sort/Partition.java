package arithmetic.sort;

/**
 * 
 * @ClassName: Partition
 * @Description:划分 节点
 * @author: 谢洪伟
 * @date: 2018年12月29日 上午9:46:32
 */
public class Partition {
	private int[] queArray;
	private int nItems;

	public Partition(int s) {
		queArray = new int[s];
		nItems = 0;
	}

	public void insert(int v) {
		queArray[nItems++] = v;
	}

	public int size() {
		return nItems;
	}

	public int patitionIt(int left, int right, int pivot) {// pivot 是个值
		int l = left - 1; // 第一个数据项的左边一位
		int r = right + 1;// 最后一个数据项的右边一位 两个指针

		while (true) {
			while (l < right && queArray[++l] < pivot) { // 小值 就继续遍历 ，大的就揪出来，不遍历; find bigger
				; // l < right 是防止 本来就有序的 l会一直加到 right 数组越界。
			}
			while (r > left && queArray[--r] > pivot) {
				; // find smaller
			}
			if (l >= r)
				break;
			else
				swap(l, r); // 交换两个坐标值。
		}
		return l;

	}

	private void swap(int l, int r) {
		int temp = queArray[l];
		queArray[l] = queArray[r];
		queArray[r] = temp;
	}

	/**
	 * 快速排序
	 */
	public void recQuickSort(int left, int right) {
		if (right - left <= 0)
			return;
		else {
			int partition = patitionIt(left, right, 44);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}

	}

}
