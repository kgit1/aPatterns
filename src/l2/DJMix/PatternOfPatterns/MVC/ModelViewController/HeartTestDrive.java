package l2.DJMix.PatternOfPatterns.MVC.ModelViewController;

public class HeartTestDrive {

	public static void main(String[] args) {
		HeartModel heartModel = new HeartModel();
		ControllerInterface model = new HeartController(heartModel);
	}
}
