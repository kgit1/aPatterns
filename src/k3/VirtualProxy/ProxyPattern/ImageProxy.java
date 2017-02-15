package k3.VirtualProxy.ProxyPattern;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

class ImageProxy implements Icon {
	ImageIcon imageIcon;
	URL imageUrl;
	Thread retrievalThread;
	boolean retrieving = false;

	public ImageProxy(URL url) {
		imageUrl = url;
	}

	@Override
	public int getIconWidth() {
		if (imageIcon != null) {
			return imageIcon.getIconWidth();
		} else {
			return 800;
		}
	}

	@Override
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 600;
		}
	}

	// method to paint image on screen
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if (imageIcon != null) {
			// if object already exists - invoke method from it
			imageIcon.paintIcon(c, g, x, y);
			// if not - show loading message
		} else {
			g.drawString("Loading CD covew, please wait...,", x + 300, y + 190);
			// if image not loading
			if (!retrieving) {
				// turn loading flag to true and load image from url
				retrieving = true;
				// give anonymous thread realization to our retrieving thread
				retrievalThread =
						// anonymous thread class
						new Thread(new Runnable() {
							// method run of anonyous thread class
							public void run() {
								try {
									// load image from url
									imageIcon = new ImageIcon(imageUrl, "CD cover");
									// call repaint method after getting actual
									// image from url
									c.repaint();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
				// start retrieving thread
				retrievalThread.start();
			}
		}
	}
}
