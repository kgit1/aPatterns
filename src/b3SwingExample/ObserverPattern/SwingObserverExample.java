package b3SwingExample.ObserverPattern;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {

	JFrame frame;
	int ask = (int) (Math.random() * 10);

	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}

	public void go() {
		frame = new JFrame();
		JButton button = new JButton("Should I do it?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		button.addActionListener(new AskListener());

		// Set frame properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class AngelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ask > 5) {
				System.out.println("Angel: Don't do it, you might regret it!");
			}
		}
	}

	class DevilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ask < 5) {
				System.out.println("Devil: Come on, do it!");
			}
		}
	}

	class AskListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ask = (int) (Math.random() * 10);
		}
	}
}
