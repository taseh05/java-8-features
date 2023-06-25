package tahaseen.training.lambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class PracticeExamples {

	public static void main(String[] args) {

		Consumer<String> printWords = new Consumer<String>() {

			@Override
			public void accept(String sentence) {
				String[] parts = sentence.split(" ");
				for (String part : parts) {
					System.out.println(part);
				}
			}
		};

		Consumer<String> printWordsLambda = sentence -> {
			String[] parts = sentence.split(" ");
			for (String part : parts) {
				System.out.println(part);
			}
		};
		printWordsLambda.accept("This is a demo of consumer interface");
		System.out.println("------------------------------------------");
		Consumer<String> printWordsForEach = sentence -> {
			String[] parts = sentence.split(" ");
			Arrays.asList(parts).forEach(p -> System.out.println(p));
		};
		printWordsForEach.accept("This is a forEach version of the consumer interface");

		System.out.println("-----------------------------------------");
		Consumer<String> printWordsLambdaConcise = sentence -> {
			Arrays.asList(sentence.split(" ")).forEach(p -> System.out.println(p));
		};
		printWordsLambdaConcise.accept("This is a concise version of the consumer interface");

		UnaryOperator<String> everySecondChar = source -> {
			StringBuilder returnVal = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				if (i % 2 == 1) {
					returnVal.append(source.charAt(i));
				}
			}
			return returnVal.toString();
		};

		System.out.println(everySecondChar.apply("abcdefghi"));
		System.out.println(everySecondCharacter(everySecondChar, "0123456789"));

		Supplier<String> java = () -> "In supplier Interface";
		String result = java.get();
		System.out.println(result);
	}

	public static String everySecondCharfunc(String source) {
		StringBuilder returnVal = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			if (i % 2 == 1) {
				returnVal.append(source.charAt(i));
			}
		}
		return returnVal.toString();
	}

	public static String everySecondCharacter(UnaryOperator<String> func, String source) {
		System.out.println("Using Unary operator");
		return func.apply(source);
	}

	public static String everySecondCharacter(Function<String, String> func, String source) {
		System.out.println("Using function");
		return func.apply(source);
	}
}
