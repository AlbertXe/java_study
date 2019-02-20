package arithmetic.link;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public void insertFirst(int data) {
		Link link = new Link(data);
		link.next = first; // 第一个数据的时候这个是 空
		first = link;
	}

	public Link find(int key) {
		Link current = first;

		while (current.data != key) {
			if (current == null)
				return null;
			else
				current = current.next;
		}
		return current;
	}

	public Link delete(int key) {
		Link current = first;
		Link previous = first;

		while (current.data != key) {
			if (current == null)
				return null;
			else {
				previous = current; // 前一节点。
				current = current.next;// 下一节点
			}
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;// 此节点删除 前后节点关系链上。
		}
		return current;

	}
}
