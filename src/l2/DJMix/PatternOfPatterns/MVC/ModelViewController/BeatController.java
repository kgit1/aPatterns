package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;

	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenu();
		model.initialize();
	}

	@Override
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenu();
	}

	@Override
	public void stop() {
		model.off();
		view.enableStartMenu();
		view.disableStopMenuItem();
	}

	@Override
	public void increaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm + 1);
	}

	@Override
	public void decreaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm - 1);
	}

	@Override
	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
