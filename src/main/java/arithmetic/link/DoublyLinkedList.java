package arithmetic.link;

/**
 * 
 * @ClassName: DoublyLinkedList
 * @Description: 双向队列
 * @author: 谢洪伟
 * @date: 2018年12月28日 上午9:43:31
 */
public class DoublyLinkedList {
	private Link1 first;
	private Link1 last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Link1 link = new Link1(data);
		if (isEmpty())
			last = link;
		else
			first.previous = link;
		link.next = first;
		first = link;
	}
}
