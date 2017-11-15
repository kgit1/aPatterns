package j8.TutorialExamples.Files;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class String1 {

	public static void main(String[] args) {

		testJoining();
		testChars();
		testPatternSplit();
		testPatternCount();
	}

	// Slicing Strings
	// Two new methods are available on the String class: join and chars. The first
	// method joins any number of strings into a single string with the given
	// delimiter

	private static void testJoining() {

		String string = String.join(":", "foobar", "foo", "bar");

		System.out.println(string);
	}

	// The second method chars creates a stream for all characters of the string, so
	// you can use stream operations upon those characters
	private static void testChars() {

		String string = "foobar:foo:bar".chars().distinct().mapToObj(c -> String.valueOf((char) c)).sorted()
				.collect(Collectors.joining());

		System.out.println(string);
	}

	// Not only strings but also regex patterns now benefit from streams. Instead of
	// splitting strings into streams for each character we can split strings for
	// any pattern and create a stream to work
	private static void testPatternSplit() {

		String string = Pattern.compile(":").splitAsStream("foobar:foo:bar").filter(s -> s.contains("bar")).sorted()
				.collect(Collectors.joining("-<>-"));

		System.out.println(string);
	}

	// Additionally regex patterns can be converted into predicates. Those
	// predicates can for example be used to filter a stream of strings
	private static void testPatternCount() {

		Pattern pattern = Pattern.compile(".*@gmail\\.com");
		long count = Stream.of("bob@gmail.com", "ros@gmail.com", "susan@yahoo.com").filter(pattern.asPredicate())
				.count();

		System.out.println(count);
	}

}
