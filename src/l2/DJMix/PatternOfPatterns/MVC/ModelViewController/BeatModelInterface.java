package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

public interface BeatModelInterface {

	// invoke on object creation
	void initialize();

	// start beat method
	void on();

	// stop beat method
	void off();

	// set beat method
	void setBPM(int bpm);

	// get beat method
	int getBPM();

	// register observer BeatObserver
	void registerObserver(BeatObserver o);

	// remove observer BeatObserver
	void removeObservr(BeatObserver o);

	// register observer BPMObserver
	void registerObserver(BPMObserver o);

	// remove observer BPMObserver
	void removeObserver(BPMObserver o);

}
