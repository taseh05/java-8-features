package tahaseen.training.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class FunctionsPreDefined {

	public static void main(String[] args) {
		int sum = calculator((a, b) -> a + b, 5, 6);
		String concat = calculator((a, b) -> a + " " + b, "first", "last");

		List<Double[]> coords = Arrays.asList(new Double[] { 123.34, 456.98 }, new Double[] { 189.34, 226.98 },
				new Double[] { 56.34, 190.98 });
		BiConsumer<Double, Double> p1 = (pt1, pt2) -> System.out.printf("[lat:%.2f  long:%.2f]\n ", pt1, pt2);
		coords.forEach(s -> processPoint(s[0], s[1], p1));
		System.out.println("------------------------------");
		var names = Arrays.asList("John", "Jane", "Chris", "Albert");
		//names.removeIf(s -> s.startsWith("J"));
		names.forEach(s -> System.out.println(s));
		System.out.println("------------------------------");
		//names.addAll(List.of("James", "June"));
		names.forEach(s -> System.out.println(s));
	}

	public static <T> T calculator(BinaryOperator<T> o, T a, T b) {
		T result = o.apply(a, b);
		System.out.println("result = " + result);
		return result;

	}

	public static <T> void processPoint(T value1, T value2, BiConsumer<T, T> consumer) {
		consumer.accept(value1, value2);
	}
}
