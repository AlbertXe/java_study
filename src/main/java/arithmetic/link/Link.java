package arithmetic.link;

public class Link {
	public int data;
	public Link next;

	public Link(int data) {
		this.data = data;
	}

	public void display() {
		System.out.println("data=" + data);
	}

}
