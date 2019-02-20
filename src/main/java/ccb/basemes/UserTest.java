package ccb.basemes;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
@User(age=27)
public class UserTest {
	@Email
	String email;

	public UserTest() {
	}
	public static void main(String[] args) {
		
		Class clz = UserTest.class;
		User user = (User) clz.getAnnotation(User.class);
		System.out.println(user.age());
		System.out.println(user.name());
		System.out.println(user.sex());
		Email ee = (Email) clz.getAnnotation(Email.class);
		System.out.println(ee);
		System.out.println(ee.email());
	}
}
