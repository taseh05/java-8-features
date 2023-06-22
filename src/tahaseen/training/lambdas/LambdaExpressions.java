package tahaseen.training.lambdas;

public class LambdaExpressions {

	public static void main(String[] args) {
		int sum = calculator((a, b) -> a + b, 5, 6);
		String concat = calculator((a, b) -> a + " " + b, "first", "last");

	}

	public static <T> T calculator(Operation<T> o, T a, T b) {
		T result = o.operate(a, b);
		System.out.println("result = " + result);
		return result;

	}

}
