package d2.Pizza.Regional.FactoryPattern.copy;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new ChicagoStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new ChicagoStylePepperoniPizza();
		} else if (type.equals("Clam")) {
			pizza = new ChicagoStyleClamPizza();
		} else if (type.equals("Veggie")) {
			pizza = new ChicagoStyleVeggiePizza();
		}
		return pizza;
	}

}
