package g1.Starbuzz.TemplateMethodPattern;

import java.awt.Graphics;

import javax.swing.JFrame;

public class JFrameHookExample extends JFrame {

	public static void main(String[] args) {
		JFrameHookExample frame = new JFrameHookExample("Example");
	}

	public JFrameHookExample(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(300, 300);
		this.setVisible(true);
	}

	// hook here - paint() method, hook method - method which has empty or some
	// default realization in parent class, and which we can override to
	// implement our behavior in this part of algorithm given by parent class
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "I RULE!!";
		graphics.drawString(msg, 200, 200);
	}
}
