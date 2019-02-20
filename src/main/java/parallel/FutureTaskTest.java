package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 
 * @ClassName: FutureTaskTest
 * @Description:
 * @author: 谢洪伟
 * @date: 2018年12月18日 下午4:35:32
 */
public class FutureTaskTest {

	public static void main(String[] args) {
		FutureTaskTest test = new FutureTaskTest();
		//1. 任务集合 2.线程池
		List<FutureTask<Integer>> taskList = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			FutureTask<Integer> task = new FutureTask<>(test.new TaskThread(i, "子线程" + i));
			taskList.add(task);
			service.submit(task);
		}
		System.out.println("所有计算任务 已提交，正在计算，主线程继续执行");
		Integer result = 0;
		for (FutureTask<Integer> futureTask : taskList) {
			try {
				System.out.println(futureTask.get());
				result += futureTask.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("总结果=" + result);

	}

	public class TaskThread implements Callable<Integer> {
		private Integer result;
		private String name;

		public TaskThread(Integer result, String name) {
			this.name = name;
			this.result = result;
		}

		public String getName() {
			return name;
		}

		@Override
		public Integer call() throws Exception {
			for (int i = 0; i < 100; i++) {
				result += i;
			}
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "执行完毕");
			return result;
		}
		
	}
}
