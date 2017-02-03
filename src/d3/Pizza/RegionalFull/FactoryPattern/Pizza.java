package d3.Pizza.RegionalFull.FactoryPattern;

import java.util.Arrays;

public abstract class Pizza {

	String name;
	String dough;
	String sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clams;

	abstract void prepare(String name);

	void bake(String name) {
		System.out.println("Bake for 25 minutes at 350 degree");
	}

	void cut(String name) {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box(String name) {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", dough=" + dough + ", sauce=" + sauce + ", veggies=" + Arrays.toString(veggies)
				+ ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", clams=" + clams + "]";
	}

}
