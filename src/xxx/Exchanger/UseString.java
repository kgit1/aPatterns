package xxx.Exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {

	Exchanger<String> exchanger;
	String str;

	public UseString(Exchanger<String> exchanger) {

		this.exchanger = exchanger;
		new Thread(this).start();

	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {

			try {

				str = exchanger.exchange(new String());
				System.out.println("Got: " + str);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
