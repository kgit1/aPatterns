package g1.Starbuzz.TemplateMethodPattern;

public class CaffeeMainWithHook {

	public static void main(String[] args) {
		TeaWithHook tea = new TeaWithHook();
		tea.prepareRecipe();

		CoffeeWithHook coffee = new CoffeeWithHook();
		coffee.prepareRecipe();

	}
}
