package d3.Pizza.¿„‰‰Regional.FactoryPattern;

import java.util.Scanner;

public class MainPizza {

	public static void main(String[] args) {

		// PizzaStore nyPizzaStore = new NYStylePizzaStore();
		// PizzaStore chicagoPizzaStore = new ChicagoStylePizzaStore();
		// PizzaStore californiaPizzaStore = new CaliforniaStylePizzaStore();
		// Pizza pizza1 = nyPizzaStore.orderPizza("pepperoni");
		// Pizza pizza2 = chicagoPizzaStore.orderPizza("clam");
		// Pizza pizza3 = californiaPizzaStore.orderPizza("cheese");
		//
		// System.out.println("==================================");
		// System.out.println(pizza1.name);
		// System.out.println("==================================");
		// System.out.println(pizza2.name);
		// System.out.println("==================================");
		// System.out.println(pizza3.name);

		buyPizza("ny", "pepperoni");
		buyPizza("chicago", "cheese");
		buyPizza("california", "clam");
		// buyPizza("california1", "clam1");
		// buyPizza("california", "clam1");
	}

	public static void buyPizza(String name, String type) {
		System.out.println("------------------------------------------");
		PizzaStore pizzaStore = null;
		if (name.equals("ny")) {
			System.out.println(1);
			pizzaStore = new NYStylePizzaStore();
		} else if (name.equals("chicago")) {
			System.out.println(2);
			pizzaStore = new ChicagoStylePizzaStore();
		} else if (name.equals("california")) {
			System.out.println(3);
			pizzaStore = new CaliforniaStylePizzaStore();
		} else {
			System.out.println(name + " is wrong pizza origin, try ny, chicago or california");
			buyPizza(new Scanner(System.in).nextLine(), type);
			return;
		}
		try {
			Pizza pizza = pizzaStore.orderPizza(type);
			System.out.println(pizza.name + " name");
		} catch (NullPointerException e) {
			// e.printStackTrace();
			System.out.println(type + " is wrong pizza type, try cheese, clam, pepperoni or veggie");
			buyPizza(name, new Scanner(System.in).nextLine());
		}
		System.out.println("------------------------------------------");
	}
}
