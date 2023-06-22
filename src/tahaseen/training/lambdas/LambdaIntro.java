package tahaseen.training.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person {
	String firstName;
	String lastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}

interface NewComparator<T> extends Comparator<T> {
	int secondLevelCompare(T p1, T p2);
}

public class LambdaIntro {

	public static void main(String[] args) {
		System.out.println("Lambda Expression Demo");

		List<Person> people = new ArrayList<>(
				Arrays.asList(new Person("Ram", "Raj"), new Person("John", "Dale"), new Person("Jill", "Dale"),
						new Person("Sita", "Raj"), new Person("Roshan", "Abbas"), new Person("Rahul", "Abbas")));

		people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
		System.out.println(people);

		var result = new NewComparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int result = o1.lastName.compareTo(o2.lastName);
				return (result == 0 ? secondLevelCompare(o1, o2) : result);
			}

			@Override
			public int secondLevelCompare(Person p1, Person p2) {
				return p1.firstName.compareTo(p2.firstName);
			}

		};
		people.sort(result);
		System.out.println("sorted first and last names" + people);
	}
}
