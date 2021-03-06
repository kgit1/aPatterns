package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class BeatModel implements BeatModelInterface, MetaEventListener {

	Sequencer sequencer;
	ArrayList<BeatObserver> beatObservers = new ArrayList<>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
	int bpm = 90;
	Sequence sequence;
	Track track;

	@Override
	// create and prepare midi generator
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}

	@Override
	// start sequencer
	public void on() {
		System.out.println("Starting the sequencer");
		sequencer.start();
		setBPM(90);
	}

	@Override
	// stop sequencer
	public void off() {
		setBPM(0);
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM());
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {
		return bpm;
	}

	private void beatEvent() {
		notifyBeatObservers();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void notifyBeatObservers() {
		for (int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = beatObservers.get(i);
			observer.updateBeat();
		}
	}

	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void notifyBPMObservers() {
		for (int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = bpmObservers.get(i);
			observer.updateBPM();
		}
	}

	@Override
	public void removeObservr(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	@Override
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	@Override
	// How can I loop a Sequence? There are several ways to do this: The obvious
	// approach is to register a MetaEventListener with the Sequencer and wait
	// for the end of track message (meta message 47). Once you receive this
	// message, set the position to 0 and call start() again. The problem with
	// this approach is that there is a small delay each time the Sequencer is
	// restarted.
	public void meta(MetaMessage meta) {
		sequencer.setMicrosecondPosition(0);
		if (meta.getType() == 47) {
			beatEvent();
			System.out.println("meta method");
			sequencer.start();
			setBPM(getBPM());
		}
	}

	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
//			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = { 35, 0, 46, 0 };

		sequence.deleteTrack(null);
		track = sequence.createTrack();

		beatEvent();
		makeTracks(trackList);
		// (192, 9, 1, 0, 4) - 192 mean change instrument,
		// 9- instrument before changed, and 1 - instrument after change
		track.add(makeEvent(192, 9, 1, 0, 4));
		try {
			sequencer.setSequence(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void makeTracks(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int key = list[i];

			if (key != 0) {
				// put message into instruction
				// 144 -(start playing the note)type of the message
				// 9 - use channel number 9 (means instrument (0 - 15))
				// 100 - the note (0 - 127)
				// i - speed and power of keystroke(nazatiya klavishi)
				System.out.println("track");
				track.add(makeEvent(144, 9, key, 100, i));
				// 128 in message means end of the note
				track.add(makeEvent(128, 9, key, 100, i + 1));
			}
		}
	}

	public MidiEvent makeEvent(int command, int channel, int data1, int data2, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, data1, data2);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
}
