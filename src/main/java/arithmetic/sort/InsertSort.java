package arithmetic.sort;

/**
 * 
 * @ClassName: InsertSort
 * @Description:插入排序
 * @author: 谢洪伟
 * @date: 2018年12月26日 下午4:10:14
 */
public class InsertSort {
	private Integer[] a;

	public void sort() {
		int in, out;

		for (out = 1; out < 100; out++) { // 第二个开始 。
			int temp = a[out];
			in = out;
			while (in > 0 && temp <= a[in - 1]) {// 循环直到 temp 刚大于一个数
				a[in] = a[in - 1]; // 填上取出的坑
				--in;
			}
			a[in] = temp;// 将数据放到左侧。
		}
	}
	
}
