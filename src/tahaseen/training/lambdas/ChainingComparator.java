package tahaseen.training.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainingComparator {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>(Arrays.asList(new Person("Peter", "Pan"),
				new Person("Peter", "PumpkinEater"), new Person("Minnie", "Mouse"), new Person("Mickey", "Mouse")));

		list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
		list.forEach(System.out::println);

		System.out.println("------------------------------------");
		list.sort(Comparator.comparing(Person::getLastName));
		list.forEach(System.out::println);

		System.out.println("------------------------------------");
		list.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
		list.forEach(System.out::println);

		System.out.println("------------------------------------");
		list.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).reversed());
		list.forEach(System.out::println);
	}

}
