package arithmetic.link;

/**
 * 
 * @ClassName: FirstLastList
 * @Description: 队列
 * @author: 谢洪伟
 * @date: 2018年12月27日 下午3:52:21
 */
public class FirstLastList {
	private Link first;
	private Link last;

	public FirstLastList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertLast(int data) {
		Link link = new Link(data);
		if (isEmpty())
			first = link;
		else {
			last.next = link; // last 后面加一个
		}
		last = link; // 移动指针
	}

	public int deleteFirst(){
		int data = first.data;
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		return data;
	}
}
