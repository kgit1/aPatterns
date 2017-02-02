package d1.Pizza.FactoryPattern;

public class Pizza {

	String name = "Some pizza";

	public void prepare() {
		System.out.println("Pizza prepared");

	}

	public void bake() {
		System.out.println("Pizza baked");
	}

	public void cut() {
		System.out.println("Pizza cut");
	}

	public void box() {
		System.out.println("Pizza boxed");
	}
}
