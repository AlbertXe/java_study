package java8.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * java8
 * 
 * @ClassName: OptionalTest
 * @Description:
 * @author: 谢洪伟
 * @date: 2019年1月18日 下午1:30:52
 */
public class OptionalTest {
	public static void main(String[] args) {
		// Optional<Integer> o0 = Optional.of(null); // 参数不能为null 异常
		Optional<Integer> o1 = Optional.of(1); // 参数不能为null
		Optional<Integer> o2 = Optional.ofNullable(2);
		Optional<Integer> o3 = Optional.ofNullable(null); // 参数可为null
		Optional<Integer> o4 = Optional.ofNullable(null); // 参数可为null
		System.out.println("o3==o4?" + (o3 == o4));
		// Optional<Integer> empty = Optional.<Integer>empty();
		System.out.println("o3 == empty?" + (o3 == Optional.<Integer> empty()));// 所有空都包装成Optional

		// isPresent 判断值是否存在
		// System.out.println("o0.isPresent?" + o0.isPresent()); 异常
		System.out.println("o1.isPresent?" + o1.isPresent());
		System.out.println("o3.isPresent?" + o3.isPresent());

		// ifPresent(Consumer consumer) 存在就调用consumer,不存在值就不调用
		o1.ifPresent(new Consumer<Integer>() {
			@Override
			public void accept(Integer arg0) {
				System.out.println("arg0=" + arg0);
			}
		});
		o2.ifPresent(arg0 -> System.out.println("agg0?" + arg0));

		// orElse(value) 空就返回value;
		Integer value2 = o2.orElse(4);
		Integer value3 = o3.orElse(4);
		System.out.println("value2?" + value2);
		System.out.println("value3?" + value3);

		// orElseGet(obj) 和orElse一样，不同：参数是对象Supplier
		Integer orElseGet2 = o2.orElseGet(() -> {
			return 100;
		});
		Integer orElseGet3 = o3.orElseGet(() -> {
			return 100;
		});
		System.out.println("orElseGet2?" + orElseGet2);
		System.out.println("orElseGet3?" + orElseGet3);

		// filter(Predicate) 判断是否满足Predicate
		Optional<Integer> filter2 = o2.filter(a -> a == 2); // 过滤一样
		Optional<Integer> filter3 = o3.filter(a -> a == null);
		System.out.println("filter2？" + filter2.get());
		System.out.println("filter3？" + filter3.isPresent());

		// map(Function) 组合计算
		Optional<String> map2 = o2.map(new Function<Integer, String>() {
			@Override
			public String apply(Integer a) {
				return "key" + a;
			}
		});
		Optional<String> map3 = o3.map((a) -> "key" + a);
		System.out.println("map2?" + map2.get());
		System.out.println("map3?" + map3.isPresent());

		// flatmap 和map 功能相同 不同：map 返回值T flatmap Optional
		Optional<String> flatMap2 = o2.flatMap((a) -> {
			return Optional.ofNullable("key" + a);
		});
		System.out.println("flatmap2?" + flatMap2.get());

	}

}
