package k3.VirtualProxy.ProxyPattern;

import java.awt.Component;
import java.awt.Graphics;

public interface Icon {

	int getIconWidth();

	int getIconHeight();

	void paintIcon(Component c, Graphics g, int x, int y);
}
