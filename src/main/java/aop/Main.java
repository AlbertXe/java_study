package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);

		GreetingThrowAdvice bean = context.getBean(GreetingThrowAdvice.class);
		System.out.println(bean);

	}
}
