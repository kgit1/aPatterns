package f1.RemoteControl.CommandPattern;

public class RemoteControlTestSimple {

	public static void main(String[] args) {

		// crate remote control object
		RemoteControlSimple remote = new RemoteControlSimple();
		// create device object
		Light light = new Light("Light");
		// create command object for command, assign device
		LightOnCommand lightOn = new LightOnCommand(light);
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
