package arithmetic.sort;

/**
 * 
 * @ClassName: ShellSort
 * @Description:高级排序：希尔排序 ；基于插入排序的 增量排序
 * @author: 谢洪伟
 * @date: 2018年12月28日 下午2:18:12
 */
public class ShellSort {
	private int[] queArray;
	private int nItems;

	public ShellSort(int s) {
		queArray = new int[s];
		nItems = 0;
	}

	public void insert(int value) {
		queArray[nItems++] = value;
	}

	public void sort() {
		int inner, outer, temp;

		int h = 1;
		while (h <= nItems / 3) {
			h = 3 * h + 1; // 1 4 13 ... 间隔
		}

		while (h > 0) { // decreasing h until h=1;
			for (outer = h; outer < nItems; outer++) { // h sort file 4
				temp = queArray[outer]; // 4
				inner = outer; // 4
				while (inner > h - 1 && queArray[inner - h] >= temp) {// [0]>[4]交换 048
					queArray[inner] = queArray[inner - h];
					inner -= h;
				}
				queArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
}
