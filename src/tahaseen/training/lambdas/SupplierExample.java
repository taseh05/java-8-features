package tahaseen.training.lambdas;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		String[] names = { "John", "Jane", "Chris", "Albert" };
		String[] selectedNames = randomValues(6, names, () -> new Random().nextInt(names.length));
		for (String name : selectedNames) {
			System.out.println("  " + name);
		}

		String[] emptyStrings = new String[10];
		Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + "");

		System.out.println("emptyStrings" + Arrays.toString(emptyStrings));

	}

	public static String[] randomValues(int count, String[] names, Supplier<Integer> s) {
		String[] selected = new String[count];
		for (int i = 0; i < count; i++) {
			selected[i] = names[s.get()];

		}
		return selected;
	}
}
