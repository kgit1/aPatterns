package e2.ChocolateBoiler.ThreadSafe.SingletonPattern;

public class MainBoiler {

	public static void main(String[] args) {
		Thread thread1 = new Thread(ChocolateBoiler.getInstance());
		Thread thread2 = new Thread(ChocolateBoiler.getInstance());
		thread1.start();
		thread2.start();
	}

}
