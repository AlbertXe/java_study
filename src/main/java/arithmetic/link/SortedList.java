package arithmetic.link;

/**
 * 
 * @ClassName: SortedList
 * @Description:有序列表 insert 不同
 * @author: 谢洪伟
 * @date: 2018年12月27日 下午4:10:00
 */
public class SortedList {
	private Link first;

	public SortedList() {
		first = null;
	}

	public void insert(int data) {
		Link link = new Link(data);
		Link previous = null;
		Link current = first;

		while (current != null && current.data < data) { // 插入数据一直 大于 数据 知道小于就插入
			previous = current;
			current = current.next;
		}

		if (previous == null) { // at begining
			first = link;
		} else {
			previous.next = link;
			link.next = current;
		}

	}

}
