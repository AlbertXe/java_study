package lammada;

import java.util.function.Consumer;

/**
 * 
 * @ClassName:  Test   
 * @Description: lamada 表达式   
 * @author: 谢洪伟 
 * @date:   2018年8月23日 下午3:59:44   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 *
 */
public class Test {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("新线程")).start();
		
		Runnable runnable = () -> System.out.println("新街口");
		runnable.run();

		Consumer<String> consumer = System.out::println;
		consumer.accept("hello");

	}
	
}
