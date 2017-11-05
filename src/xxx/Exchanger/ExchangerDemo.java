package xxx.Exchanger;

import java.util.concurrent.Exchanger;

//Exchanger - a synchronization point at which threads can pair and
// swap elements
// within pairs. Each thread presents some object on entry to the
// exchange method, matches with a partner thread, and receives its
// partner's object on return.
public class ExchangerDemo {

	public static void main(String[] args) {

		// Sample Usage: Here are the highlights of a class that uses an
		// Exchanger to swap buffers between threads so that the thread filling
		// the buffer gets a freshly emptied one when it needs it, handing off
		// the filled one to the thread emptying the buffer.
		Exchanger<String> exchanger = new Exchanger<String>();

		new UseString(exchanger);
		new MakeSting(exchanger);

	}
}
