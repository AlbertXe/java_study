package lammada;

import java.util.stream.IntStream;

public class IntStreamTest {
	public static void main(String[] args) {
		IntStream.range(3, 5).map(n -> n * n).forEach(System.out::println);
		IntStream.rangeClosed(3, 5).map(n -> n * n).forEach(System.out::print);
		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum);
		IntStream.of(13, 2, 3, 5, 7, 1).sorted().forEach(System.out::println);

	}
}
