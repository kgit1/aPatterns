package x2.Calories;

//Basal Metabolic Rate : 
//Your basal metabolic rate is the total amount of energy (calories) your body requires daily just to maintain normal
//bodily functions, including digestion, circulation, respiration, temperature regulation, cell construction and every 
//other process in your body. BMR is the total of all the energy you use for basic bodily functions, not including 
//physical activity
public class CaloriesCalc {

	public static void main(String[] args) {
		System.out.println("Harris–Benedict formula :            " + calcHarrisBenedict(99, 183.5, 32, 1));
		System.out.println("Mifflin - St Jeor formula :          " + calcMifflinStJeor(99, 183.5, 32, 1));
		System.out.println("Katch-McArdle formula :              " + calcKatchMcArdle(99, 0.3, 1));
		System.out.println("World Health Organization formula :  " + calcWorldHealthOrganization(99, 1));
		// System.out.println("Tkachenko formula : " + calcTkachenko(99,
		// 183.5,1));

	}

	// Harris–Benedict equation (formula)
	public static double calcHarrisBenedict(double bodyWeight, double bodyHeight, int age, double activity) {
		// Little to no exercise Daily kilocalories needed = BMR x 1.2
		// Light exercise (1–3 days per week) Daily kilocalories needed = BMR x
		// 1.375
		// Moderate exercise (3–5 days per week) Daily kilocalories needed = BMR
		// x 1.55
		// Heavy exercise (6–7 days per week) Daily kilocalories needed = BMR x
		// 1.725
		// Very heavy exercise (twice per day, extra heavy workouts) Daily
		// kilocalories needed = BMR x 1.9
		if (activity == 1) {
			activity = 1.2;
		} else if (activity == 2) {
			activity = 1.375;
		} else if (activity == 3) {
			activity = 1.55;
		} else if (activity == 4) {
			activity = 1.725;
		} else if (activity == 5) {
			activity = 1.9;
		}
		double bmr = activity * (88.362 + (13.397 * bodyWeight) + (4.799 * bodyHeight) - (5.677 * age));
		return bmr;
	}

	// Mifflin - St Jeor equation (formula)
	// Why This Formula?
	// The ADA (American Dietetic Association) published a comparison of various
	// equations2. The Mifflin-St Jeor was
	// found to be the most accurate.
	public static double calcMifflinStJeor(double bodyWeight, double bodyHeight, int age, double activity) {
		// Little to no exercise Daily kilocalories needed = BMR x 1.2
		// Light exercise (1–3 days per week) Daily kilocalories needed = BMR x
		// 1.375
		// Moderate exercise (3–5 days per week) Daily kilocalories needed = BMR
		// x 1.55
		// Heavy exercise (6–7 days per week) Daily kilocalories needed = BMR x
		// 1.725
		// Very heavy exercise (twice per day, extra heavy workouts) Daily
		// kilocalories needed = BMR x 1.9
		if (activity == 1) {
			activity = 1.2;
		} else if (activity == 2) {
			activity = 1.375;
		} else if (activity == 3) {
			activity = 1.55;
		} else if (activity == 4) {
			activity = 1.725;
		} else if (activity == 5) {
			activity = 1.9;
		}
		double bmr = activity * (9.99 * bodyWeight + 6.25 * bodyHeight - 4.92 * age + 5);
		return bmr;
	}

	// Katch-McArdle equation (formula)
	public static double calcKatchMcArdle(double bodyWeight, double bodyFat, double activity) {
		// Little to no exercise Daily kilocalories needed = BMR x 1.2
		// Light exercise (1–3 days per week) Daily kilocalories needed = BMR x
		// 1.375
		// Moderate exercise (3–5 days per week) Daily kilocalories needed = BMR
		// x 1.55
		// Heavy exercise (6–7 days per week) Daily kilocalories needed = BMR x
		// 1.725
		// Very heavy exercise (twice per day, extra heavy workouts) Daily
		// kilocalories needed = BMR x 1.9
		if (activity == 1) {
			activity = 1.2;
		} else if (activity == 2) {
			activity = 1.375;
		} else if (activity == 3) {
			activity = 1.55;
		} else if (activity == 4) {
			activity = 1.725;
		} else if (activity == 5) {
			activity = 1.9;
		}
		double bmr = activity * (370 + (21.6 * bodyWeight * (1 - bodyFat)));
		return bmr;
	}

	public static double calcWorldHealthOrganization(double bodyWeight, double activity) {
		double bmr;
		// Little to no exercise Daily kilocalories needed = BMR x 1.2
		// Light exercise (1–3 days per week) Daily kilocalories needed = BMR x
		// 1.375
		// Moderate exercise (3–5 days per week) Daily kilocalories needed = BMR
		// x 1.55
		// Heavy exercise (6–7 days per week) Daily kilocalories needed = BMR x
		// 1.725
		// Very heavy exercise (twice per day, extra heavy workouts) Daily
		// kilocalories needed = BMR x 1.9
		if (activity == 1) {
			activity = 1.2;
		} else if (activity == 2) {
			activity = 1.375;
		} else if (activity == 3) {
			activity = 1.55;
		} else if (activity == 4) {
			activity = 1.725;
		} else if (activity == 5) {
			activity = 1.9;
		}
		bmr = activity * (0.0484 * bodyWeight + 3.653) * 240;
		return bmr;
	}

	// something wrong

	// Tkachenko equation (formula)
	// (11,3 * weight (kg)) + (16 * height (meters)) +901
	// public static double calcTkachenko(double bodyWeight, double bodyHeight,
	// double activity) {
	// double bmr;
	// // Little to no exercise Daily kilocalories needed = BMR x 1.2
	// // Light exercise (1–3 days per week) Daily kilocalories needed = BMR x
	// // 1.375
	// // Moderate exercise (3–5 days per week) Daily kilocalories needed = BMR
	// // x 1.55
	// // Heavy exercise (6–7 days per week) Daily kilocalories needed = BMR x
	// // 1.725
	// // Very heavy exercise (twice per day, extra heavy workouts) Daily
	// // kilocalories needed = BMR x 1.9
	// if (activity == 1) {
	// activity = 1.2;
	// } else if (activity == 2) {
	// activity = 1.375;
	// } else if (activity == 3) {
	// activity = 1.55;
	// } else if (activity == 4) {
	// activity = 1.725;
	// } else if (activity == 5) {
	// activity = 1.9;
	// }
	// bmr = activity * ((11.3 * bodyWeight) + (16 * bodyHeight) + 901);
	// System.out.println((11.3 * bodyWeight));
	// System.out.println((16 * bodyHeight));
	// return bmr;
	// }
}
