package d3.Pizza.RegionalFull.FactoryPattern;

public class ClamPizza extends Pizza {

	PizzaIngredientFactory ingridientFactory;

	public ClamPizza(PizzaIngredientFactory ingridientFactory) {
		this.ingridientFactory = ingridientFactory;
	}

	@Override
	void prepare(String name) {
		System.out.println(name + " preparing...");
		dough = ingridientFactory.createDough();
		System.out.println("Tossing " + dough + " dough");
		sauce = ingridientFactory.createSauce();
		System.out.println("Adding sause " + sauce);
		cheese = ingridientFactory.createCheese();
		System.out.println("Adding toppings : " + cheese);
		clams = ingridientFactory.createClams();
		System.out.println("Adding toppings : " + clams);
	}
}
