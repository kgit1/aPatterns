package j8.Features;

import java.util.ArrayList;
import java.util.List;

public class StreamsVsLoopTest {

	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 0; i < 5000000; i++) {

			list.add(i);
		}

		long startTime;
		long endTime;

		int result = 0;

		startTime = System.nanoTime();
		for (int i : list) {

			if (i % 2 == 0) {

				result += i;
			}
		}
		endTime = System.nanoTime();
		System.out.println(result);
		System.out.println("Loop time: " + (double) (endTime - startTime) / 1000000.0);

		startTime = System.nanoTime();
		System.out.println(list.stream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
		endTime = System.nanoTime();
		System.out.println("Stream time: " + (double) (endTime - startTime) / 1000000.0);

		startTime = System.nanoTime();
		System.out.println(list.parallelStream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
		endTime = System.nanoTime();
		System.out.println("Parallel stream time: " + (double) (endTime - startTime) / 1000000.0);

		// limited
		startTime = System.nanoTime();
		System.out.println(
				list.parallelStream().limit(1000).filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
		endTime = System.nanoTime();
		System.out.println("Parallel stream limited time: " + (double) (endTime - startTime) / 1000000.0);

	}

}
