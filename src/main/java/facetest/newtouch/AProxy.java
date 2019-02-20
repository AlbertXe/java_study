package facetest.newtouch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AProxy<T> implements InvocationHandler {
	private T t;

	private T getProxy(T t) {
		this.t = t;
		return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
	}

	public Object invoke(Object obj, Method method, Object[] params) {
		Object result = null;
		try {
			obj = method.invoke(t, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
