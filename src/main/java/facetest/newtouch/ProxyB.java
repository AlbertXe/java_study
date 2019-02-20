package facetest.newtouch;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyB implements MethodInterceptor {
	private Object target;

	public ProxyB(Object target) {
		this.target = target;
	}

	public Object getProxy(Object object) {
		return Enhancer.create(target.getClass(), this);
	}

	@Override
	public Object intercept(Object paramObject, Method paramMethod, Object[] paramArrayOfObject, MethodProxy paramMethodProxy) throws Throwable {
		return paramMethodProxy.invoke(paramObject, paramArrayOfObject);
	}

}
