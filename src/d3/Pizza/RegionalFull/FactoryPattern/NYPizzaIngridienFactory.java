package d3.Pizza.RegionalFull.FactoryPattern;

public class NYPizzaIngridienFactory implements PizzaIngridientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianCheese();
	}

	@Override
	public Vegies[] createVegies() {
		Vegies vegies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return vegies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClams() {
		return new FreshClams();
	}

}
