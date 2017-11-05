package xxx.Exchanger;

import java.util.concurrent.Exchanger;

public class MakeSting implements Runnable {

	Exchanger<String> exchanger;
	String str;

	public MakeSting(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
		str = new String();
		new Thread(this).start();
	}

	@Override
	public void run() {

		char ch = 'A';

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				str += (char) ch++;
			}
			try {

				System.out.println("Sending: " + str);
				
				str = exchanger.exchange(str);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
