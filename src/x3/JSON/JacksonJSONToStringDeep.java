package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

public class JacksonJSONToStringDeep {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println();

		try {
			File jsonFile = new File("mapDeep.json");
			Map<String, Object> mapObject = objectMapper.readValue(jsonFile, new TypeReference<Map<String, Object>>() {
			});
			Iterator<Entry<String, Object>> it = mapObject.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				System.out.println(entry.getKey());
				Iterator<Entry<String, Object>> it2 = ((Map<String, Object>) entry.getValue()).entrySet().iterator();
				while (it2.hasNext()) {
					Entry<String, Object> entry2 = it2.next();
					System.out.println(entry2.getKey() + ": ");
					Iterator<Entry<String, Object>> it3 = ((Map<String, Object>) entry2.getValue()).entrySet()
							.iterator();
					while (it3.hasNext()) {
						Entry<String, Object> entry3 = it3.next();
						System.out.print("\t" + entry3.getKey() + ": ");
						System.out.println(entry3.getValue());
					}
				}
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

// Summarize other answers and what I known, I found 10 main ways to do this
// (see below). And I wrote some performance tests (see results below), for
// example, if we want to find sum of all keys and values of map, we can write :

// Using iterator and Map.Entry
// long i = 0;
// Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
// while (it.hasNext()) {
// Map.Entry<Integer, Integer> pair = it.next();
// i += pair.getKey() + pair.getValue();}

// Using foreach and Map.Entry
// long i = 0;
// for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
// i += pair.getKey() + pair.getValue();}

// Using forEach from Java 8
// final long[] i = {0};
// map.forEach((k, v) -> i[0] += k + v);
// Using keySet and foreach
// long i = 0;
// for (Integer key : map.keySet()) {
// i += key + map.get(key);}

// Using keySet and iterator
// long i = 0;
// Iterator<Integer> itr2 = map.keySet().iterator();
// while (itr2.hasNext()) {
// Integer key = itr2.next();
// i += key + map.get(key);}

// Using for and Map.Entry
// long i = 0;
// for (Iterator<Map.Entry<Integer, Integer>> entries =
// map.entrySet().iterator(); entries.hasNext(); ) {
// Map.Entry<Integer, Integer> entry = entries.next();
// i += entry.getKey() + entry.getValue();}

// Using Java 8 Stream Api
// final long[] i = {0};
// map.entrySet().stream().forEach(e -> i[0] += e.getKey() + e.getValue());
// Using Java 8 Stream Api parallel
// final long[] i = {0};
// map.entrySet().stream().parallel().forEach(e -> i[0] += e.getKey() +
// e.getValue());
// Using IterableMap of Apache Collections
// long i = 0;
// MapIterator<Integer, Integer> it = iterableMap.mapIterator();
// while (it.hasNext()) {
// i += it.next() + it.getValue();}

// Using MutableMap of Eclipse (CS) collections
// final long[] i = {0};
// mutableMap.forEachKeyValue((key, value) -> {
// i[0] += key + value;});

// Perfomance tests (mode = AverageTime, system = Win 8.1 64-bit, Intel i7-4790
// 3.60GHz 3.60GHz, 16 GB)

// 1) For small map (100 elements), score 0.308 is the best

// Benchmark Mode Cnt Score Error Units
// test3_UsingForEachAndJava8 avgt 10 0.308 ± 0.021 us/op
// test10_UsingEclipseMap avgt 10 0.309 ± 0.009 us/op
// test1_UsingWhileAndMapEntry avgt 10 0.380 ± 0.014 us/op
// test6_UsingForAndIterator avgt 10 0.387 ± 0.016 us/op
// test2_UsingForEachAndMapEntry avgt 10 0.391 ± 0.023 us/op
// test7_UsingJava8StreamApi avgt 10 0.510 ± 0.014 us/op
// test9_UsingApacheIterableMap avgt 10 0.524 ± 0.008 us/op
// test4_UsingKeySetAndForEach avgt 10 0.816 ± 0.026 us/op
// test5_UsingKeySetAndIterator avgt 10 0.863 ± 0.025 us/op
// test8_UsingJava8StreamApiParallel avgt 10 5.552 ± 0.185 us/op
// 2) For map with 10000 elements, score 37.606 is the best

// Benchmark Mode Cnt Score Error Units
// test10_UsingEclipseMap avgt 10 37.606 ± 0.790 us/op
// test3_UsingForEachAndJava8 avgt 10 50.368 ± 0.887 us/op
// test6_UsingForAndIterator avgt 10 50.332 ± 0.507 us/op
// test2_UsingForEachAndMapEntry avgt 10 51.406 ± 1.032 us/op
// test1_UsingWhileAndMapEntry avgt 10 52.538 ± 2.431 us/op
// test7_UsingJava8StreamApi avgt 10 54.464 ± 0.712 us/op
// test4_UsingKeySetAndForEach avgt 10 79.016 ± 25.345 us/op
// test5_UsingKeySetAndIterator avgt 10 91.105 ± 10.220 us/op
// test8_UsingJava8StreamApiParallel avgt 10 112.511 ± 0.365 us/op
// test9_UsingApacheIterableMap avgt 10 125.714 ± 1.935 us/op
// 3) For map with 100000 elements, score 1184.767 is the best

// Benchmark Mode Cnt Score Error Units
// test1_UsingWhileAndMapEntry avgt 10 1184.767 ± 332.968 us/op
// test10_UsingEclipseMap avgt 10 1191.735 ± 304.273 us/op
// test2_UsingForEachAndMapEntry avgt 10 1205.815 ± 366.043 us/op
// test6_UsingForAndIterator avgt 10 1206.873 ± 367.272 us/op
// test8_UsingJava8StreamApiParallel avgt 10 1485.895 ± 233.143 us/op
// test5_UsingKeySetAndIterator avgt 10 1540.281 ± 357.497 us/op
// test4_UsingKeySetAndForEach avgt 10 1593.342 ± 294.417 us/op
// test3_UsingForEachAndJava8 avgt 10 1666.296 ± 126.443 us/op
// test7_UsingJava8StreamApi avgt 10 1706.676 ± 436.867 us/op
// test9_UsingApacheIterableMap avgt 10 3289.866 ± 1445.564 us/op
// Graphs (perfomance tests depending on map size)

// enter image description here

// Table (perfomance tests depending on map size)

// 100 600 1100 1600 2100
// test10 0.333 1.631 2.752 5.937 8.024
// test3 0.309 1.971 4.147 8.147 10.473
// test6 0.372 2.19 4.47 8.322 10.531
// test1 0.405 2.237 4.616 8.645 10.707
// test2 0.376 2.267 4.809 8.403 10.91
// test7 0.473 2.448 5.668 9.79 12.125
// test9 0.565 2.83 5.952 13.22 16.965
// test4 0.808 5.012 8.813 13.939 17.407
// test5 0.81 5.104 8.533 14.064 17.422
// test8 5.173 12.499 17.351 24.671 30.403
