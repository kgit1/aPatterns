package f1.RemoteControl.CommandPattern;

public class StereoCommandOn implements Command {

	Stereo stereo;

	public StereoCommandOn(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume();
	}

	@Override
	public void undo() {
		stereo.off();
	}
}
