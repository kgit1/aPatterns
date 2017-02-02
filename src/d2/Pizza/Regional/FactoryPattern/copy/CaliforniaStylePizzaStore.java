package d2.Pizza.Regional.FactoryPattern.copy;

public class CaliforniaStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new CaliforniaStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			return new CaliforniaStylePepperoniPizza();
		} else if (type.equals("Clam")) {
			return new CaliforniaStyleClamPizza();
		} else if (type.equals("Veggie")) {
			return new CaliforniaStyleVeggiePizza();
		} else
			return null;
	}
}
