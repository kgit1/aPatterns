package d2.Pizza.Regional.FactoryPattern.copy;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else if (type.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (type.equals("Veggie")) {
			return new NYStyleVeggiePizza();
		} else
			return null;
	}
}
