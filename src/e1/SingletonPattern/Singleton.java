package e1.SingletonPattern;

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
