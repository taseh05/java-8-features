package tahaseen.training.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MethodReferences2 {

	public static void main(String[] args) {
		String[] names = { "Azfar", "Habeeb", "John", "Jane", "Sam", "Bob", "Anna" };
		System.out.println("names:" + Arrays.toString(names));
		List<String> backedByArray = Arrays.asList(names);
		backedByArray.replaceAll(String::toUpperCase);
		System.out.println("names in upper case" + Arrays.toString(names));
		List<String> newNames = Arrays.asList(names);
		newNames.replaceAll(s -> s + " " + addMiddleName() + ".");
		System.out.println("After adding middle names:" + newNames);
		List<String> lastNames = List.of(names).stream().map(s -> s + " " + reverse(s.split(" ")[0]))
				.collect(Collectors.toList());
		System.out.println("names with reversed first-name as last-name" + lastNames);
		lastNames.removeIf(s -> s.substring(0, s.indexOf(" ")).equalsIgnoreCase(s.substring(s.lastIndexOf(" ") + 1)));
		System.out.println("After removing identical first and last names: " + lastNames);

	}

	public static String reverse(String name) {

		return new StringBuilder(name).reverse().toString();
	}

	public static char addMiddleName() {
		return (char) (new Random().nextInt(26) + 'a');

	}
}
