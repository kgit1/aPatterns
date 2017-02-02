package d2.Pizza.Regional.FactoryPattern.copy;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new NYStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new NYStylePepperoniPizza();
		} else if (type.equals("Clam")) {
			pizza = new NYStyleClamPizza();
		} else if (type.equals("Veggie")) {
			pizza = new NYStyleVeggiePizza();
		}
		return pizza;
	}

}
