package tahaseen.training.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PracticeExamples2 {

	public static void main(String[] args) {
		String[] names = { "John", "Habeeb", "Anna", "Bob", "Azfar", "Liril" };
		Arrays.setAll(names, i -> names[i].toUpperCase());
		System.out.println("names in upper case");
		System.out.println(Arrays.toString(names));
		List.of(names).forEach(s -> System.out.println(s));
		List<String> backedArray = Arrays.asList(names);
		backedArray.replaceAll(s -> s + " " + randomChar('A') + ".");
		System.out.println("Randomly generated middle name------------------");
		System.out.println(backedArray);
		backedArray.replaceAll(s -> s + " " + reverseName(s.split(" ")[0]));
		System.out.println("Added reverse of firstName as lastName------------------");
		System.out.println(backedArray);

		List<String> newNames = new ArrayList<>(List.of(names));
		newNames.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)));
		System.out.println("After removing identical first and last names");
		//System.out.println(newNames);
		newNames.forEach(s -> System.out.println(s));
	}

	public static char randomChar(char endChar) {
		return (char) new Random().nextInt(endChar);
	}

	public static String reverseName(String name) {
		return new StringBuilder(name).reverse().toString();
	}
}
