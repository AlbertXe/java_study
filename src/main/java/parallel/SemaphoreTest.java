package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * @ClassName:  SemaphoreTest   
 * @Description:信号量
 * @author: 谢洪伟 
 * @date:   2018年12月13日 下午4:46:14
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(5);
		ExecutorService pool = Executors.newFixedThreadPool(50);
		
		for (int i = 0; i < 50; i++) {
			System.out.println(i);
			try {
				sem.acquire(2);
				pool.execute(()->System.out.println(Thread.currentThread().getName()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				sem.release(2);
			}
			
		}
		
		
	}
}
