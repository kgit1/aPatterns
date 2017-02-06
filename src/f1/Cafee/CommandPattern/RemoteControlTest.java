package f1.Cafee.CommandPattern;

public class RemoteControlTest {

	public static void main(String[] args) {

		// crate remote control object
		SimpleRemoteControl remote = new SimpleRemoteControl();
		// create device object
		Light light = new Light();
		// create command object for command, assign device
		LightOnCommant lightOn = new LightOnCommant(light);
		// create device object
		GarageDoor garageDoor = new GarageDoor();
		// create command object for command, assign device
		GarageDoorOpenCommand openGarage = new GarageDoorOpenCommand(garageDoor);

		// assign command object to remote
		remote.setCommand(lightOn);
		// invoke execute method of Command object
		remote.buttonWasPressed();

		// assign command object to remote
		remote.setCommand(openGarage);
		// invoke execute method of Command object
		remote.buttonWasPressed();

	}
}
