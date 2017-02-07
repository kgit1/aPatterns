package f1.RemoteControl.CommandPattern;

public class StereoCommandOff implements Command {
	Stereo stereo;

	public StereoCommandOff(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}

	@Override
	public void undo() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume();
	}
}
