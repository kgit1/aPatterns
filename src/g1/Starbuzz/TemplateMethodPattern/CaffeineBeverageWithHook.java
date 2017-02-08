package g1.Starbuzz.TemplateMethodPattern;

public abstract class CaffeineBeverageWithHook {

	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	abstract void brew();

	abstract void addCondiments();

	public void boilWater() {
		System.out.println("Boiling water");
	}

	private void pourInCup() {
		System.out.println("Pouring into cup");
	}

	// hook, empty or almost empty method, subclass can override this method,
	// but is not obliged too
	boolean customerWantsCondiments() {
		return true;
	}
}
