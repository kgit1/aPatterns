package j8.TutorialExamples.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Files1 {

	public static final String FILE_NAME = "test.txt";

	public static void main(String[] args) {

		testWalk();
		testFind();
		testList();
		testLines();
		testReader();
		testWriter();
		testReadWriteLines();
		testCountLines();

	}

	private static void testCountLines() {
		Path path = Paths.get(FILE_NAME);

		try (BufferedReader reader = Files.newBufferedReader(path)) {

			long countPrints = reader.lines().filter(line -> line.contains("print")).count();

			System.out.println("testCountLines(): " + countPrints);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testWriter() {

		Path path = Paths.get(FILE_NAME);

		String data = testreaderWithReturn(FILE_NAME) + "\nprint('Hello World');";

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {

			writer.write(data);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testReader() {

		Path path = Paths.get(FILE_NAME);

		try (BufferedReader reader = Files.newBufferedReader(path)) {

			System.out.println("reader(): " + reader.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String testreaderWithReturn(String filename) {

		Path path = Paths.get(FILE_NAME);

		try (BufferedReader reader = Files.newBufferedReader(path)) {

			Stream<String> lines = reader.lines();
			String fileData = lines.map(String::valueOf).collect(Collectors.joining("\n"));
			System.out.println("testreaderWithReturn(): " + fileData);

			return fileData;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Empty";
	}

	private static void testWalk() {

		Path start = Paths.get("");

		int maxDepth = 5;

		try (Stream<Path> stream = Files.walk(start, maxDepth)) {

			String joined = stream.map(String::valueOf).filter(path -> path.endsWith(".json"))
					.collect(Collectors.joining("; "));

			System.out.println("walk(): " + joined);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testFind() {

		Path start = Paths.get("");

		int maxDepth = 5;

		try (Stream<Path> stream = Files.find(start, maxDepth,
				(path, attr) -> String.valueOf(path).endsWith(".json"))) {

			String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining("; "));

			System.out.println("find(): " + joined);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void testList() {

		try (Stream<Path> stream = Files.list(Paths.get(""))) {

			String joined = stream.map(String::valueOf).filter(path -> !path.startsWith(".")).sorted()
					.collect(Collectors.joining("; "));

			System.out.println("list(): " + joined);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testLines() {

		try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {

			System.out.print("testLines(): ");
			stream.filter(line -> line.contains("print")).map(String::trim).forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testReadWriteLines() {

		try {

			List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

			lines.add("print('foobar');");
			Files.write(Paths.get(FILE_NAME), lines);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
