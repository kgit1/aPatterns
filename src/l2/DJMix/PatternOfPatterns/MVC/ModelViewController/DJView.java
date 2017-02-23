package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DJView implements ActionListener, BeatObserver, BPMObserver {

	// refer to model object
	BeatModelInterface model;
	// refer to controller object
	ControllerInterface controller;
	JFrame viewFrame;
	JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
	JFrame controlFrame;
	JPanel controlPanel;
	JLabel bpmLabel;
	JTextField bpmTextField;
	JButton setBPMButton;
	JButton increaseBPMButton;
	JButton decreaseBPMButton;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem startMenuItem;
	JMenuItem stopMenuItem;

	public DJView(ControllerInterface controller, BeatModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
	}

	public void createView() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		viewPanel = new JPanel(new GridLayout(1, 2));
		viewFrame = new JFrame("View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(100, 80));
		// SwingConstants - a collection of constants generally used for
		// positioning and orienting components on the screen.
		// LEFT - box-orientation constant used to specify the left side of a
		// box.
		bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
		JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.setSize(new Dimension(300, 400));
		bpmPanel.add(beatBar);
		bpmPanel.add(bpmOutputLabel);
		viewPanel.add(bpmPanel);
		viewPanel.setSize(new Dimension(300, 400));
		viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setSize(new Dimension(300, 400));
		viewFrame.setVisible(true);
	}

	public void createControls() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		controlFrame = new JFrame("Control");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setSize(new Dimension(100, 80));

		controlPanel = new JPanel(new GridLayout(1, 2));

		menuBar = new JMenuBar();
		menu = new JMenu("DJ Control");
		startMenuItem = new JMenuItem("Start");
		menu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});

		stopMenuItem = new JMenuItem("Stop");
		menu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
				// bpmOutputLabel.setText("offline");
			}
		});

		JMenuItem exit = new JMenuItem("Quit");
		menu.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Terminates the currently running Java Virtual Machine. The
				// argument serves as a status code; by convention, a nonzero
				// status code indicates abnormal termination.
				System.exit(0);
			}
		});

		menuBar.add(menu);
		controlFrame.setJMenuBar(menuBar);

		bpmTextField = new JTextField(2);
		bpmTextField.setText("0");
		// SwingConstants - a collection of constants generally used for
		// positioning and orienting components on the screen.
		// RIGHT - box-orientation constant used to specify the right side of a
		// box.
		bpmLabel = new JLabel("Enter BPM: ", SwingConstants.RIGHT);
		setBPMButton = new JButton("Set");
		setBPMButton.setSize(new Dimension(10, 40));
		increaseBPMButton = new JButton(">>");
		decreaseBPMButton = new JButton("<<");
		setBPMButton.addActionListener(this);
		increaseBPMButton.addActionListener(this);
		decreaseBPMButton.addActionListener(this);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

		JPanel enterPanel = new JPanel(new GridLayout(1, 2));
		enterPanel.add(bpmLabel);
		enterPanel.add(bpmTextField);

		JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
		insideControlPanel.add(enterPanel);
		insideControlPanel.add(setBPMButton);
		insideControlPanel.add(buttonPanel);
		controlPanel.add(insideControlPanel);

		bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		controlFrame.getRootPane().setDefaultButton(setBPMButton);
		controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

		// Causes this Window to be sized to fit the preferred size and layouts
		// of its subcomponents. The resulting width and height of the window
		// are automatically enlarged if either of dimensions is less than the
		// minimum size as specified by the previous call to the setMinimumSize
		// method
		controlFrame.pack();
		// make controlFrame frame(window) - visible
		controlFrame.setVisible(true);
	}

	public void enableStopMenu() {
		// setEnabled() - enables or disables the menu item
		stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
		// setEnabled() - enables or disables the menu item
		stopMenuItem.setEnabled(false);
	}

	public void enableStartMenu() {
		// setEnabled() - enables or disables the menu item
		startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
		// setEnabled() - enables or disables the menu item
		startMenuItem.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// event.getSource() - returns:The object on which the Event
		// initially occurred
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBPM(bpm);
			// event.getSource() - returns:The object on which the Event
			// initially occurred
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
			// event.getSource() - returns:The object on which the Event
			// initially occurred
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
	}

	public void updateBPM() {
		int bpm = model.getBPM();
		if (bpm == 0) {
			bpmOutputLabel.setText("offline");
		} else {
			bpmOutputLabel.setText("Current BPM: " + model.getBPM());
		}
	}

	public void updateBeat() {
		beatBar.setValue(Integer.parseInt(bpmLabel.getText()));
	}
}
