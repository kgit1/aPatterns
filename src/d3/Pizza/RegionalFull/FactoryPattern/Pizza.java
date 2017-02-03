package d3.Pizza.RegionalFull.FactoryPattern;

import java.util.ArrayList;

public class Pizza {

	String name = "Some pizza";
	String dough = "usual dough";
	String sauce = "usual sause";
	ArrayList toppings = new ArrayList();

	public void prepare(String name) {
		System.out.println(name + " preparing");
		System.out.println("Tossing " + dough + " dough");
		System.out.println("Adding sause " + sauce);
		System.out.println("Adding toppings...");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println(" " + toppings.get(i));
		}

	}

	public void bake(String name) {
		System.out.println("Bake for 25 minutes at 350 degree");
	}

	public void cut(String name) {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box(String name) {
		System.out.println("Place pizza in official PizzaStore box");
	}
}
