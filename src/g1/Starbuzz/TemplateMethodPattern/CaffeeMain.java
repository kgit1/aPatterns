package g1.Starbuzz.TemplateMethodPattern;

public class CaffeeMain {

	public static void main(String[] args) {
		Tea tea = new Tea();
		tea.prepareRecipe();

		Coffee coffee = new Coffee();
		coffee.prepareRecipe();

	}

}
