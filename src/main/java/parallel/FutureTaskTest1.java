package parallel;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @ClassName: FutureTaskTest1
 * @Description: 高并发确保只执行一次
 * @author: 谢洪伟
 * @date: 2018年12月18日 下午5:05:41
 */
public class FutureTaskTest1 {
	private ConcurrentHashMap<String, FutureTask<Connection>> pool = new ConcurrentHashMap<>();

	public Connection getConnection(String key) {
		FutureTask<Connection> task = pool.get(key);
		Connection connection = null;
		if (task != null)
			try {
				task.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		else {
			FutureTask<Connection> newTask;
			// newTask = new FutureTask(() -> {
			//
			// });
			Callable<Connection> call = new Callable<Connection>() {

				@Override
				public Connection call() throws Exception {
					return createConnection();
				}
			};
			newTask = new FutureTask<>(call);
			pool.put(key, newTask);

			try {
				connection = newTask.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	private Connection createConnection() {
		return null;
	}

	public static void main(String[] args) {

	}
}
