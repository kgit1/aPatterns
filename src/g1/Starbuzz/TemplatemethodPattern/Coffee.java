package g1.Starbuzz.TemplatemethodPattern;

public class Coffee {

	void prepareRecipe() {
		boilWater();
		brewCoffeeGrinds();
		pourInCup();
		addSugarAndMilk();
	}

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public void brewCoffeeGrinds() {
		System.out.println("Dripping coffee through filter");
	}

	private void pourInCup() {
		System.out.println("Pouring into cup");
	}

	private void addSugarAndMilk() {
		System.out.println("Adding sugar and milk");
	}
}
