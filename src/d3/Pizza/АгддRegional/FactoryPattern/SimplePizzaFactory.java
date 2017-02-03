package d3.Pizza.¿„‰‰Regional.FactoryPattern;

public class SimplePizzaFactory {
	
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("Clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("Veggie")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}
}
