package tahaseen.training.lambdas;

import java.util.function.BinaryOperator;

public class MethodReferences {
	public static void main(String[] args) {
		calculator(Integer::sum, 10, 30);
		calculator(String::concat, "Azfar", "Habeeb");
		calculator(Double::sum, 23.45, 89.789);
	}

	public static <T> void calculator(BinaryOperator<T> func, T a, T b) {

		T result = func.apply(a, b);
		System.out.println("result = " + result);
	}
}
