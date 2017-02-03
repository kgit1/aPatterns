package d3.Pizza.RegionalFull.FactoryPattern;

public class ChicagoPizzaIngridienFactory implements PizzaIngridientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new Mozzarella();
	}

	@Override
	public Vegies[] createVegies() {
		Vegies vegies[] = { new Spinach(), new BlackOlives(), new EggPlant() };
		return vegies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClams() {
		return new FrozenClams();
	}

}
