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
		for (; ; ) {
			System.out.println("getValue");			
			int value1 = getValue();
			if(value1==1){
				System.out.println("Value 100");
				value1=100;
			}
			// if(value<50){
			// value=75;
			// }else{
			// value=25;
			// }
			setValue(value1);
			value1 = (int) (value1 * 0.95);
			setValue(value1);
			repaint();
			 System.out.println("1 " + value1);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}
}
