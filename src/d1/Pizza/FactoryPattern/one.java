package d1.Pizza.FactoryPattern;

public class one {

	public static void main(String[] args) {
		PizzaStore pz = new PizzaStore(new SimplePizzaFactory());
		Pizza pizza = pz.orderPizza("pepperoni");
		System.out.println(pizza.name);
	}
}
