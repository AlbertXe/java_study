package utils;

public class TestPO {
	@Check("1")
	private String name = "";
	@Check("2")
	private boolean sex = true;
	@Check("3")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		TestPO po = new TestPO();
		po.setAge(90);
		po.setName("xxx");
		int age2 = po.getAge();
		String name2 = po.getName();
		po.setAge(92);
		po.setName("hhh");
		System.out.println(age2);
		System.out.println(name2);

	}
}
