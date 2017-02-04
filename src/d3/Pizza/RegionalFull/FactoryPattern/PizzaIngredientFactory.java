package d3.Pizza.RegionalFull.FactoryPattern;

//factory pattern here
public interface PizzaIngredientFactory {

	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public Veggies[] createVeggies();

	public Pepperoni createPepperoni();

	public Clams createClams();

}
