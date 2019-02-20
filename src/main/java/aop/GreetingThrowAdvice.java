package aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("method?" + method.getName());
		System.out.println("target?" + target.getClass());
		System.out.println("exception？" + ex.getMessage());
	}
}
