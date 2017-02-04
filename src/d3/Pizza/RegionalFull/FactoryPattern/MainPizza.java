package d3.Pizza.RegionalFull.FactoryPattern;

import java.util.Scanner;

public class MainPizza {

	public static void main(String[] args) {

		buyPizza("ny", "pepperoni");
		buyPizza("chicago", "cheese");
		buyPizza("california", "clam");
		// buyPizza("california1", "clam1");
		// buyPizza("california", "clam1");

		// PizzaStore nyStore = new NYStylePizzaStore();
		// PizzaStore chicagoStore = new ChicagoStylePizzaStore();
		//
		// Pizza pizza = nyStore.orderPizza("cheese");
		// System.out.println("Ethan ordered a " + pizza + "\n");
		//
		// pizza = chicagoStore.orderPizza("cheese");
		// System.out.println("Joel ordered a " + pizza + "\n");
		//
		// pizza = nyStore.orderPizza("clam");
		// System.out.println("Ethan ordered a " + pizza + "\n");
		//
		// pizza = chicagoStore.orderPizza("clam");
		// System.out.println("Joel ordered a " + pizza + "\n");
		//
		// pizza = nyStore.orderPizza("pepperoni");
		// System.out.println("Ethan ordered a " + pizza + "\n");
		//
		// pizza = chicagoStore.orderPizza("pepperoni");
		// System.out.println("Joel ordered a " + pizza + "\n");
		//
		// pizza = nyStore.orderPizza("veggie");
		// System.out.println("Ethan ordered a " + pizza + "\n");
		//
		// pizza = chicagoStore.orderPizza("veggie");
		// System.out.println("Joel ordered a " + pizza + "\n");
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
