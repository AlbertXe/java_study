package aop;

import org.springframework.stereotype.Component;

@Component
public class GreeingImpl implements Greeting {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

}
