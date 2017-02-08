package g1.Starbuzz.TemplateMethodPattern;

public abstract class CaffeineBeverage {

	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	abstract void brew();

	abstract void addCondiments();

	public void boilWater() {
		System.out.println("Boiling water");
	}

	private void pourInCup() {
		System.out.println("Pouring into cup");
	}
}
