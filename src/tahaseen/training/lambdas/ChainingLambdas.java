package tahaseen.training.lambdas;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ChainingLambdas {

	public static void main(String[] args) {
		String name = "Tahaseen";
		UnaryOperator<String> nameInCapitals = String::toUpperCase;
		UnaryOperator<StringBuilder> reverse = StringBuilder::reverse;
		System.out.println(nameInCapitals.apply(name));
		UnaryOperator<String> lastName = s -> s.concat(" Munavvara");
		System.out.println(lastName.apply(name));
		Function<String, String> fullName = nameInCapitals.andThen(s -> s.concat(" Munavvara"));
		System.out.println(fullName.apply(name));
		Function<String, String> composeName = nameInCapitals.compose(lastName);
		System.out.println("fullname using compose:" + composeName.apply(name));

		Function<String, Object> chaining = nameInCapitals.andThen(s -> s.concat(" Munavvara"))
				.andThen(a -> a.split(" ")).andThen(s -> s[1].toUpperCase() + " " + s[0]);
		System.out.println(reverse.apply(new StringBuilder("Bob Effigo")));
		System.out.println(chaining.apply(name));

		Predicate<String> result = s -> s.contains("Taha");
		System.out.println(result.test("Tahaseen"));
		name = "john";

		Predicate<String> p1 = s -> s.equals("John");
		Predicate<String> p2 = s -> s.equalsIgnoreCase("John");
		Predicate<String> p3 = s -> s.startsWith("J");
		Predicate<String> p4 = s -> s.endsWith("e");

		Predicate<String> combined1 = p1.or(p2);
		System.out.println("combined1 = " + combined1.test(name));

		Predicate<String> combined2 = p3.and(p4);
		System.out.println("combined2 = " + combined2.test(name));

		Predicate<String> combined3 = p3.and(p4).negate();
		System.out.println("combined3 = " + combined3.test(name));
	}
}
