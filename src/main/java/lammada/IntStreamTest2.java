package lammada;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamTest2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// IntStream.range(1, 1000000).sum();

		IntPredicate rang = i -> i > 100 && i < 1000;
		IntStream.range(1, 1000000).filter(rang).parallel().sum();
		System.out.println(System.currentTimeMillis() - start);

	}
}
