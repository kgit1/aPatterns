package h2.HomeTheater.FacadePattern;

//minimum informativeness principle
public class CarMinimalInfoExample {

	// component belongs to class - we can call his methods
	Engine engine;

	public CarMinimalInfoExample() {
	}

	// key - given object - methods call acceptable
	public void start(Key key) {
		// doors - new created object - methods call acceptable
		Doors doors = new Doors();

		// key - given object - methods call acceptable
		boolean authorised = key.turns();

		if (authorised) {

			// engine - objects component - methods call acceptable
			engine.start();

			// local method - call acceptable
			updateDashBoardDisplay();

			// object created by current method - call acceptable
			doors.lock();
		}
	}

	private void updateDashBoardDisplay() {
		// TODO Auto-generated method stub
	}

}
