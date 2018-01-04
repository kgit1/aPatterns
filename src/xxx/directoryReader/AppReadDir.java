package xxx.directoryReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppReadDir {

	private static List<String> names = new ArrayList<>();
	static int i = 1;

	public static void main(String[] args) {

		File directory = new File("D:\\Games\\dope");
		Path path = directory.toPath();

		try {
			// Files.list(path).sorted().forEach(System.out::println);
			Files.list(path).sorted().forEach(name -> printString(name));
			;
		} catch (IOException e) {

			e.printStackTrace();
		}

		printList(names);

	}

	private static void printString(Path name) {

		String fileName = name.toString().replaceAll("D:\\\\Games\\\\dope\\\\", "").replaceAll("_", "")
				.replaceAll("'", "").trim();
		// System.out.println(fileName);
		names.add(fileName);
	}

	private static void printList(List<String> names) {

		// System.out.println("||||| NAMES |||||||||||||||");
		// names.stream().sorted().forEach(name -> System.out.println((i++) + " " +
		// name));

		try (FileWriter writer = new FileWriter(new File("D:\\Games\\dope\\mCatalog.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

			bufferedWriter.write("||||| NAMES |||||||||||||||");
			bufferedWriter.newLine();
			names.stream().sorted().forEach(name -> {
				try {
					bufferedWriter.write((i++) + ": " + name);
					bufferedWriter.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

// userList.stream()
// .map(user -> {
// counter.getAndIncrement();
// return new Foo(getName(user), getId(user));
// })
// .forEach(fooList::add);
// or
//
// userList.stream()
// .map(user -> new Foo(getName(user), getId(user)))
// .forEach(foo -> {
// fooList.add(foo);
// counter.getAndIncrement();
// });
