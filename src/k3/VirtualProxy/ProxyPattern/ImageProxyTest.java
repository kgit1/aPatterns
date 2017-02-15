package k3.VirtualProxy.ProxyPattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageProxyTest {
	ImageComponent imageComponent;

	// create JFrame
	JFrame frame = new JFrame("CD Cover Viewer");
	// menu bar
	JMenuBar menuBar;
	// menu
	JMenu menu;
	// create map to hold sets of "Album name" - "Cover image url"
	HashMap<String, String> cds = new HashMap<>();

	public static void main(String[] args) throws Exception {
		ImageProxyTest testDrive = new ImageProxyTest();
	}

	public ImageProxyTest() throws Exception {
		cds.put("Ambient: Music for Airports", "http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
		cds.put("Buddha Bar", "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
		cds.put("Ima", "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
		cds.put("Karma", "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
		cds.put("MCMXC A.D.", "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
		cds.put("Northern Exposure", "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
		cds.put("Selected Ambient Works, Vol. 2", "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");

		// create new URL and pass value from pa - got buy given key
		URL initialURL = new URL((String) cds.get("Selected Ambient Works, Vol. 2"));
		// create menu bar object
		menuBar = new JMenuBar();
		// create menu object with given title
		menu = new JMenu("Favorite CDs");
		// add menu object to menu bar object
		menuBar.add(menu);
		// put menu bar object on frame
		frame.setJMenuBar(menuBar);

		// fill menu object with items
		// by iteration through maps keySet, got by keySet() method
		for (String string : cds.keySet()) {
			String name = string;
			// create nem menu element with given title
			JMenuItem menuItem = new JMenuItem(name);
			// add menu element to menu
			menu.add(menuItem);
			// add action listener to menu item
			menuItem.addActionListener(
					// action listener realized with anonymous class
					// ActionListener
					new ActionListener() {
						// method actionPerformed of ActionListenerClass
						public void actionPerformed(ActionEvent event) {
							// call set icon method from imageComponent
							imageComponent.setIcon(
									// give new ImageProxy object
									new ImageProxy(
											// give URL by invoking getCDUrl()
											// method which buy name pulls
											// string with url from map of urls,
											// using name as key
											// and transform received string to
											// url
											getCDUrl(
													// give name to getCDURL
													// method
													// obtaining it by invoking
													// getActionCommand() which
													// returns the command
													// string associated with
													// this action
													event.getActionCommand())));
							frame.repaint();
						}
					});
		}

		// for (Enumeration e = cds.keys(); e.hasMoreElements();) {
		// String name = (String) e.nextElement();
		// JMenuItem menuItem = new JMenuItem(name);
		// menu.add(menuItem);
		// menuItem.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent event) {
		// imageComponent.setIcon(new
		// ImageProxy(getCDUrl(event.getActionCommand())));
		// frame.repaint();
		// }
		// });
		// }

		// set up frame and menus

		// create new icon object by initializing url
		Icon icon = new ImageProxy(initialURL);
		// create new imageComponent and give it an icon object
		imageComponent = new ImageComponent(icon);
		// add imageComponent on the frame
		frame.getContentPane().add(imageComponent);
		// set close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// give sizes to frame
		frame.setSize(800, 600);
		// make frame(window) visible
		frame.setVisible(true);

	}

	// method which buy name pulls
	// string with url from map of urls,
	// using name as key
	URL getCDUrl(String name) {
		try {
			// and transform received string to url
			return new URL((String) cds.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}