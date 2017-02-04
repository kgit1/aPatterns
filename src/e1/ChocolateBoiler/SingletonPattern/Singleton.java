package e1.ChocolateBoiler.SingletonPattern;

public class Singleton {
	private static Singleton uniqueInstance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			return new Singleton();
		}
		return uniqueInstance;
	}

}
