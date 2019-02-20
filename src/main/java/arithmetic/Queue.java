package arithmetic;

/**
 * 
 * @ClassName: Queue
 * @Description:模拟队列
 * @author: 谢洪伟
 * @date: 2018年12月27日 上午9:23:05
 */
public class Queue {
	// 1.maxSize 2.int[] 3.front 4.rear 5.nItems
	private int maxSize;
	private int[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int s) {
		maxSize = s;
		queArray = new int[maxSize];
		front = 0;
		rear = -1; // 队尾的指针 在对头
		nItems = 0;
	}

	public void insert(int i) {
		if (rear == maxSize - 1) // 当前指针在 队尾的话
			rear = -1;
		queArray[++rear] = i; // 循环队列。
		nItems++;
	}

	public int remove() {// 只改变 队列头部
		int temp = queArray[front++]; // get and incr
		if (front == maxSize) // 可不是maxSize-1;
			front = 0;
		nItems--;
		return temp;
	}

	public int peekFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

	public int size() {
		return nItems;
	}

}
