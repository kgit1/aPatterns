package d2.Pizza.Regional.FactoryPattern.copy;

public class one {

	public static void main(String[] args) {
		PizzaStore pz = new NYStylePizzaStore();
		Pizza pizza = pz.orderPizza("pepperoni");
		System.out.println(pizza.name);
	}
}
