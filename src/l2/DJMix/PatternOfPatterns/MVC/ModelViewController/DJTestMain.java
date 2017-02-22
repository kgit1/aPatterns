package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

public class DJTestMain {

	public static void main(String[] args) {
		BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
	}
}
