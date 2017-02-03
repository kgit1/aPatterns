package d2.Pizza.Regional.FactoryPattern;

public interface PizzaIngridientFactory {

	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public Vegies[] createVegies();

	public Pepperoni createPepperoni();

	public Clams createClams();

}
