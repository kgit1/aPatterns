package f1.Cafee.CommandPattern;

public class StereoCommandOff implements Command {
	Stereo stereo;

	public StereoCommandOff(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}
}
