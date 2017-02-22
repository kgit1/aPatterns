package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DJView implements ActionListener, BeatObserver, BPMObserver {

	BeatModelInterface model;
	ControllerInterface controller;
	JFrame jFrame;
	JPanel jpanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;

	public DJView(ControllerInterface controller, BeatModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
	}

	public void createView() {
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
		beatBar.setValue(100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
