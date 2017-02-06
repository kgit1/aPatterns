package f1.Cafee.CommandPattern;

//some device
public class GarageDoor {

	// available commands for device
	public void up() {
		System.out.println("Garage Door is Open");
	}

	public void down() {
		System.out.println("Garage Door is Closed");
	}

	public void stop() {
		System.out.println("Garage Door is Stoped");
	}

	public void lightOn() {
	}

	public void lightOf() {
	}
}
