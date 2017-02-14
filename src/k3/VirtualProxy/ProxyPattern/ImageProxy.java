package k3.VirtualProxy.ProxyPattern;

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

	@Override
	public void paintIcon() {
		// TODO Auto-generated method stub

	}

}
