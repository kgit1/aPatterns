package d2.Pizza.Regional.FactoryPattern.copy;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (type.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else if (type.equals("Clam")) {
			return new ChicagoStyleClamPizza();
		} else if (type.equals("Veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else
			return null;
	}
}
