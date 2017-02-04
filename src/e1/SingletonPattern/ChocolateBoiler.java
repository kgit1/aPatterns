package e1.SingletonPattern;

public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler instance;

	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (instance == null) {
			System.out.println("Creating unique instance of Chocolate Boiler");
			return new ChocolateBoiler();
		}
		System.out.println("Returning instance of Chocolate Boiler");
		return instance;
	}

	// fill boiler with ingredients
	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}

	// drain boiler after boiling
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}

	// boil filled boiler
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

}
