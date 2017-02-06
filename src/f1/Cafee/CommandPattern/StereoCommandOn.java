package f1.Cafee.CommandPattern;

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
}
