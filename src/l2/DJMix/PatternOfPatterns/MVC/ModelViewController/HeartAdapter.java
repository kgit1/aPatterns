package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

public class HeartAdapter implements BeatModelInterface {

	HeartModelInterface heart;

	public HeartAdapter(HeartModelInterface heart) {
		this.heart = heart;
	}

	@Override
	public void initialize() {
	}

	@Override
	public void on() {
	}

	@Override
	public void off() {
	}

	@Override
	public void setBPM(int bpm) {
	}

	@Override
	public int getBPM() {
		return heart.getHeartRate();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		heart.registerObserver(o);
	}

	@Override
	public void removeObservr(BeatObserver o) {
		heart.removeObserver(o);
	}

	@Override
	public void registerObserver(BPMObserver o) {
		heart.registerObserver(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		heart.removeObserver(o);
	}
}
