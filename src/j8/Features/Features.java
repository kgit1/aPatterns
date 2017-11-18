package j8.Features;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Features {

	public static void main(String[] args) {

		// String.join()=========================================================================================================
		// join set of strings to one string with separator
		String result = String.join(" | ", "A", "B", "C", "D");
		System.out.println(result);

		// with collections and streams
		Collection<String> strings = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
		result = strings.stream().filter(i -> i != null || i.isEmpty()).collect(Collectors.joining(" - "));

		System.out.println(strings);
		System.out.println(result);

		// Map.computeIfAbsent()/getOrDefault()/merge()/putIfAbsent()=========================================================================
		// we have map of strings as key and number of occurrences as value
		// we take another collection of strings and if string occurred in map we
		// increments it's value by 1
		// if occurred but initialized by null or 0 = change value to 1
		// and if not occurred at all - put to map with value 1
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 1);
		data.put("B", 2);
		data.put("C", null);

		System.out.println(data);

		// old way
		// for (String string : strings) {
		// if (!data.containsKey(string) || data.get(string) == null) {
		// data.put(string, 0);
		// }
		// data.put(string, data.get(string) + 1);
		// }

		// new way
		// for (String string: strings) {
		// data.merge(string, 1, (a,b) -> a+b);
		// }

		// short new way
		strings.forEach(s -> data.merge(s, 1, (a, b) -> a + b));

		System.out.println(data);

		// comparator
		// old
		// public class ByScoreComparator implements Comparator<User> {
		//
		// @Override
		// public int compare(User u1, User u2) {
		// return (int) signum(o2.getAge() - o1.getAge());
		// }
		// }

		// new
		// Comparator<User> comparator = Comparator
		// .comparingDouble(User::getAge)
		// .thenComparing(User::getName);
		// List<User> hList = new ArrayList<>();
		// hList.sort(comparator);
		
		//to replace all characters in list now you can just
		//list.replaceAll(String::toLowerCase);

	}

}
