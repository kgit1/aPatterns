package d3.Pizza.RegionalFull.FactoryPattern;

public class VeggiePizza extends Pizza {

	PizzaIngredientFactory ingridientFactory;

	public VeggiePizza(PizzaIngredientFactory ingridientFactory) {
		this.ingridientFactory = ingridientFactory;
	}

	@Override
	void prepare(String name) {
		System.out.println(name + " preparing...");
		dough = ingridientFactory.createDough();
		System.out.println("Tossing " + dough + " dough");
		sauce = ingridientFactory.createSauce();
		System.out.println("Adding sause " + sauce);
		veggies = ingridientFactory.createVeggies();
		for (Veggies veggies2 : veggies) {
			System.out.println("Adding toppings : " + veggies2);
		}
	}
}
