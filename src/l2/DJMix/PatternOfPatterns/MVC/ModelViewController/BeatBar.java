package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

import javax.swing.JProgressBar;

public class BeatBar extends JProgressBar implements Runnable {
	JProgressBar progressBar;
	Thread thread;

	public BeatBar() {
		thread = new Thread(this);
		setMaximum(100);
		thread.start();
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			int value = getValue();
			// if(value<50){
			// value=75;
			// }else{
			// value=25;
			// }
			value = (int) (value * 0.75);
			setValue(value);
			repaint();
//			System.out.println("1 " + value);
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}
		}
	}
}
