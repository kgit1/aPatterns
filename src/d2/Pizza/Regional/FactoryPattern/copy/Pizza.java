package d2.Pizza.Regional.FactoryPattern.copy;

public class Pizza {

	String name = "Some pizza";

	public void prepare(String name) {
		System.out.println(name + "  prepared");

	}

	public void bake(String name) {
		System.out.println(name + "  baked");
	}

	public void cut(String name) {
		System.out.println(name + "  cut");
	}

	public void box(String name) {
		System.out.println(name + " boxed");
	}
}
