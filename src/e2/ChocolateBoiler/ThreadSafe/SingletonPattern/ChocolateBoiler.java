package e2.ChocolateBoiler.ThreadSafe.SingletonPattern;

public class ChocolateBoiler implements Runnable {

	private boolean empty;
	private boolean boiled;
	private int boiler = 0;
	private volatile static ChocolateBoiler instance;

	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				System.out.println("Creating unique instance of Chocolate Boiler");
				return new ChocolateBoiler();
			}
		}
		System.out.println("Returning instance of Chocolate Boiler");
		return instance;
	}

	// fill boiler with ingredients
	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiler += 500;
			boiled = false;
		}
	}

	// drain boiler after boiling
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
			boiler -= 500;
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

	@Override
	public void run() {
		r();
	}

	public void r() {
		for (int i = 0; i < 100; i++) {
			System.out.println("1boiler: " + boiler);
			fill();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("2boiler: " + boiler);
			boil();
			drain();
			System.out.println("3boiler: " + boiler);
		}
	}

}
