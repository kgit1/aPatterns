package f1.Cafee.CommandPattern;

public class RemoteControlTest {

		public static void main(String[] args) {
			
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommant lightOn = new LightOnCommant(light);
		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOpenCommand openGarage = new GarageDoorOpenCommand(garageDoor);

		remote.setCommand(lightOn);
		remote.buttonWasPressed();

		remote.setCommand(openGarage);
		remote.buttonWasPressed();

	}
}
