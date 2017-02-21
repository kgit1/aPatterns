package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;

public class BeatModel implements BeatModelInterface, MetaEventListener {

	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList<>();
	ArrayList bmpObservers = new ArrayList<>();

	@Override
	public void meta(MetaMessage meta) {
		// TODO Auto-generated method stub

	}

	@Override
	// create and prepare midi generator
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}

	@Override
	// start sequencer
	public void on() {
		sequencer.start();
		steBpm(90);
	}

	@Override
	// stop sequencer
	public void off() {
		setBpm(0);
		Sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBpm(getBPM());
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {
		return bpm;
	}

	@Override
	public void registerObserver(BeatObserver o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObservr(BeatObserver o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerObserver(BPMObserver o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub

	}
}
