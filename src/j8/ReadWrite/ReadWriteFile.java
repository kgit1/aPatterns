package j8.ReadWrite;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReadWriteFile {

	public static void main(String[] args) {
		// Files.lines()/readAllLines()/BufferedReader.lines()=========================================================================================================
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		String input = "FileInputStream and BufferedReader vs FileReader and BufferedReader"
				+ "\nThe difference between the two methods is how to construct a BufferedReader object. "
				+ "\nMethod 1 uses InputStreamReader and Method 2 uses FileReader. What's the difference between "
				+ "\nthe two classes? An InputStreamReader is a bridge from byte streams to character streams: "
				+ "\nIt reads bytes and decodes them into characters using a specified charset. InputStreamReader "
				+ "\ncan handle other input streams than files, such as network connections, classpath resources, "
				+ "\nZIP files, etc.\r\n"
				+ "\nFileReader is a convenience class for reading character files. The constructors of this class "
				+ "\nassume that the default character encoding and the default byte-buffer size are appropriate. "
				+ "\nFileReader does not allow you to specify an encoding other than the platform default encoding. "
				+ "\nTherefore, it is not a good idea to use it if the program will run on systems with different "
				+ "\nplatform encoding.";

		File file = new File("numbers");

		// writeJ7WithFileOutputStream(file, numbers);

		// readJ7WithFileInputStream(file);

		// rewriteJ7WithFileReaderFileWriter(file);

		// readJ7WithFileInputStream(file);
		// appendJ7File(file, input);
		// readJ7LineByLineWithFileInputStream(file);

		// readJ8LineByLine(file).forEach(System.out::println);

		// printJ8LineByLine(file);

		writeJ8LineByLine(file, numbers);

		// printJ8LineByLine/(file);

		appendJ8(file, input);

		printJ8LineByLine(file);

		// printJ8LineByLineTrimEmpty(file);

	}

	private static void writeJ8LineByLine(File file, int[] numbers) {

		try (BufferedWriter buffer = Files.newBufferedWriter(Paths.get(file.getPath()), Charset.forName("UTF-8"))) {

			for (Integer number : numbers) {

				buffer.write(String.valueOf(number));
				buffer.newLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void appendJ8(File file, String input) {

		try (OutputStream out = Files.newOutputStream(file.toPath(), StandardOpenOption.APPEND,
				StandardOpenOption.CREATE)) {

			out.write(input.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<String> readJ8LineByLine(File file) {

		try {

			return Files.readAllLines(file.toPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();

	}

	private static void printJ8LineByLine(File file) {

		try {

			Files.lines(file.toPath()).forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void printJ8LineByLineTrimEmpty(File file) {

		try {
			Files.lines(Paths.get(file.getPath())).map(s -> s.trim()).filter(s -> !s.isEmpty())
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void writeJ7LineByLineWithFileOutputStream(File file, int[] numbers) {

		try (FileOutputStream fos = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {

			for (Integer number : numbers) {

				bw.write(number.toString());
				bw.newLine();

			}

			System.out.println("Writing succes");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void readJ7LineByLineWithFileInputStream(File file) {

		try (FileInputStream fis = new FileInputStream(file);

				BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {

			String line = null;

			while ((line = br.readLine()) != null) {

				System.out.println(line);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void rewriteJ7WithFileReaderFileWriter(File file) {

		List<String> list = new ArrayList<>();

		try (FileReader reader = new FileReader(file); BufferedReader buffer = new BufferedReader(reader)) {

			String line = null;

			for (int i = 1; (line = buffer.readLine()) != null; i++) {

				list.add(line + "      |      " + i + "i");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileWriter writer = new FileWriter(file); BufferedWriter buffer = new BufferedWriter(writer)) {

			for (String line : list) {

				buffer.write(line);
				buffer.newLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void appendJ7File(File file, String input) {

		try (FileWriter writer = new FileWriter(file, true); BufferedWriter buffer = new BufferedWriter(writer)) {

			writer.write(input);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// old
	// private static void writeJ6WithFileOutputStream(File file, int[] numbers) {
	//
	// FileOutputStream fos = null;
	// BufferedWriter bw = null;
	//
	// try {
	//
	// fos = new FileOutputStream(file);
	// bw = new BufferedWriter(new OutputStreamWriter(fos));
	//
	// for (Integer number : numbers) {
	// bw.write(number.toString());
	// bw.newLine();
	// }
	//
	// System.out.println("Writing succesful");
	//
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// bw.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }
	// private static void readJ6WithFileInputStream(File file) {
	//
	// FileInputStream fis = null;
	// BufferedReader br = null;
	//
	// try {
	//
	// fis = new FileInputStream(file);
	// br = new BufferedReader(new InputStreamReader(fis));
	//
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// br.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }

}
