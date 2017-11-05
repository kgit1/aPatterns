package xxx.temp.oca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomArray {

	private int originalArray[];

	public static void main(String[] args) {

		final long startTime = System.currentTimeMillis();

		app(100000);

		final long endTime = System.currentTimeMillis();
		final double durationTime = (endTime - startTime)/1000d;
		
		//System.out.println(startTime);
		//System.out.println(endTime);
		System.out.println("Time: " + durationTime);

	}

	private static void app(int originalArraySize) {

		RandomArray randomArray = new RandomArray();
		randomArray.originalArray = new int[originalArraySize];

		for (int i = 0; i < randomArray.originalArray.length; i++) {

			randomArray.originalArray[i] = (int) (Math.random() * 2) + 1;

		}

		System.out.println("OriginalArray " + randomArray.originalArray.length);
		System.out.println(Arrays.toString(randomArray.originalArray));

		int tempValue = 0;
		int counter = 0;
		// int iterationsCounter = 0;
		List<ArrayList<Integer>> data = new ArrayList<>();

		for (int i = 0; i < randomArray.originalArray.length; i++) {

			if (i == 0) {

				tempValue = randomArray.originalArray[i];

			} else if (tempValue != randomArray.originalArray[i]) {

				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(tempValue);
				tempList.add(counter);

				data.add(tempList);

				tempValue = randomArray.originalArray[i];
				counter = 0;

			}

			counter++;
			// iterationsCounter++;

			if (i == randomArray.originalArray.length - 1) {

				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(tempValue);
				tempList.add(counter);

				data.add(tempList);

			}

		}

		// System.out.println(randomArray.originalArray.length + " " +
		// iterationsCounter);
		System.out.print("DataArray ");
		System.out.println(data.size());

		// int dataMembersCounter = 0;
		int talesDataCount = 0;
		int headsDataCount = 0;
		int talesMaxEncounter = 0;
		int headsMaxEncounter = 0;
		String maxEncounterName = new String();
		int maxEncounter = 0;
		for (int i = 0; i < data.size(); i++) {

			// int prevCount = dataMembersCounter;

			// dataMembersCounter += data.get(i).get(1);

			if (data.get(i).get(0) == 1) {

				talesDataCount += data.get(i).get(1);

				if (talesMaxEncounter < data.get(i).get(1)) {

					talesMaxEncounter = data.get(i).get(1);

					if (maxEncounter < talesMaxEncounter) {

						maxEncounter = talesMaxEncounter;
						maxEncounterName = "Tales";

					}

				}

			} else {

				headsDataCount += data.get(i).get(1);

				if (headsMaxEncounter < data.get(i).get(1)) {

					headsMaxEncounter = data.get(i).get(1);

					if (maxEncounter < headsMaxEncounter) {

						maxEncounter = headsMaxEncounter;
						maxEncounterName = "Heads";

					}

				}

			}

			if (data.get(i).get(1) > maxEncounter) {

				maxEncounter = data.get(i).get(1);

			}

			//System.out.print("i " + i + " ");

			//System.out.println(data.get(i).toString());

			// System.out.print(prevCount + " + " + data.get(i).get(1) + " = ");

			// System.out.println("dataMembersCounter " + dataMembersCounter);

		}

		// System.out.println(dataMembersCounter);
		System.out.println("Tales: " + talesDataCount);
		System.out.println("Heads: " + headsDataCount);
		System.out.println("Tales max: " + talesMaxEncounter);
		System.out.println("Heads max: " + headsMaxEncounter);
		System.out.println("Max encouted: " + maxEncounter + " " + maxEncounterName);

	}

}
