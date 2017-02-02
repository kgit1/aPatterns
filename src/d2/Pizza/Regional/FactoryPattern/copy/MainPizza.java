package d2.Pizza.Regional.FactoryPattern.copy;

public class MainPizza {

	public static void main(String[] args) {
		PizzaStore pz1 = new NYStylePizzaStore();
		PizzaStore pz2 = new NYStylePizzaStore();
		PizzaStore pz3 = new CaliforniaStylePizzaStore();
		Pizza pizza1 = pz1.orderPizza("pepperoni");
		Pizza pizza2 = pz2.orderPizza("clam");
		Pizza pizza3 = pz3.orderPizza("cheese");

		System.out.println("==================================");
		System.out.println(pizza1.name);
		System.out.println("==================================");
		System.out.println(pizza2.name);
		System.out.println("==================================");
		System.out.println(pizza3.name);
	}
}
