package d3.Pizza.¿„‰‰Regional.FactoryPattern;

public abstract class PizzaStore {

	public PizzaStore() {
	}

	public Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare(pizza.name);
		pizza.bake(pizza.name);
		pizza.cut(pizza.name);
		pizza.box(pizza.name);
		return pizza;
	}

	abstract Pizza createPizza(String type);
}
