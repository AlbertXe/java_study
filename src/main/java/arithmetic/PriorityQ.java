package arithmetic;

/**
 * 
 * @ClassName: PriorityQ
 * @Description:优先级 队列
 * @author: 谢洪伟
 * @date: 2018年12月27日 上午10:21:49
 */
public class PriorityQ {
	private int maxSize;
	private int[] queArray;
	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new int[maxSize];
		nItems = 0;
	}

	public void insert(int v) {
		int i;
		//
		if (nItems == 0) // 空 特例
			queArray[nItems++] = v;
		else { // 遍历 nItems;
			for (i = nItems - 1; i > 0; i--) {
				if (v > queArray[i]) { // 最小的排在上面。
					queArray[i + 1] = queArray[i];
				} else {
					break;
				}
			}
			queArray[i + 1] = v; // 终于找到适合v 的位置。
			nItems++;
		}
	}

	public int remove() {
		return queArray[nItems--];

	}

	public int peekMin() {
		return queArray[nItems - 1];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}
}
