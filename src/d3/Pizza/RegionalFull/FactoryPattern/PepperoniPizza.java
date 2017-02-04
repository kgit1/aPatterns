package d3.Pizza.RegionalFull.FactoryPattern;

public class PepperoniPizza extends Pizza {

	PizzaIngredientFactory ingridientFactory;

	public PepperoniPizza(PizzaIngredientFactory ingridientFactory) {
		this.ingridientFactory = ingridientFactory;
	}

	@Override
	void prepare(String name) {
		System.out.println(name + "preparing...");
		dough = ingridientFactory.createDough();
		System.out.println("Tossing " + dough + " dough");
		sauce = ingridientFactory.createSauce();
		System.out.println("Adding sause " + sauce);
		cheese = ingridientFactory.createCheese();
		System.out.println("Adding toppings : " + cheese);
		pepperoni = ingridientFactory.createPepperoni();
		System.out.println("Adding toppings : " + pepperoni);
	}
}
