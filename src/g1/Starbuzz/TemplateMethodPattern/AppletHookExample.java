package g1.Starbuzz.TemplateMethodPattern;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletHookExample extends Applet {

	String message;

	public void init() {
		message = "Hello World, I'm alive";
		repaint();
	}

	public void start() {
		message = "Now i'm starting up";
		repaint();
	}

	public void stop() {
		message = "Oh, now i'm being stoped";
		repaint();
	}

	public void destroy() {
	}

	// hook here - paint() method, hook method - method which has empty or some
	// default realization in parent class, and which we can override to
	// implement our behavior in this part of algorithm given by parent class
	public void paint(Graphics graphics) {
		graphics.drawString(message, 100, 100);
	}

}
