package f1.Cafee.CommandPattern;

public class RemoteControlTest {

	private static TV tv;

	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();

		Light livingRoomLight = new Light("Living Room");
		LivingRoomLightOnCommand livingRoomLightOnCommand = new LivingRoomLightOnCommand(livingRoomLight);
		LivingRoomLightOffCommand lightOffCommand = new LivingRoomLightOffCommand(livingRoomLight);

		Stereo stereo = new Stereo("Living Room");
		StereoCommandOn stereoOn = new StereoCommandOn(stereo);
		StereoCommandOff stereoOff = new StereoCommandOff(stereo);

		TV tv = new TV("Living Room");
		TVOnCommand tvOnCommand = new TVOnCommand(tv);
		TVOffCommand tvOffCommand = new TVOffCommand(tv);

		Light kitchenLight = new Light("Kitchen");
		KitchenLightOnCommand kitchenLightOnCommand = new KitchenLightOnCommand(kitchenLight);
		KitchenLightOffCommand kiLightOffCommand = new KitchenLightOffCommand(kitchenLight);

		CeilingFan ceilingFan = new CeilingFan("Kitchen");
		CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

		Hottub hottub = new Hottub();
		HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);
		HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);

		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
		GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

		Light garageLight = new Light("Garage");
		GarageLightOnCommand garageLightOnCommand = new GarageLightOnCommand(garageLight);
		GarageLightOffCommand gaLightOffCommand = new GarageLightOffCommand(garageLight);

		remote.setCommand(0, livingRoomLightOnCommand, lightOffCommand);
		remote.commandsOn[0].execute();
		remote.commandsOff[0].execute();

		remote.setCommand(1, stereoOn, stereoOff);
		remote.commandsOn[1].execute();
		remote.commandsOff[1].execute();

		remote.setCommand(2, tvOnCommand, tvOffCommand);
		remote.commandsOn[2].execute();
		remote.commandsOff[2].execute();

		remote.setCommand(3, kitchenLightOnCommand, kiLightOffCommand);
		remote.commandsOn[3].execute();
		remote.commandsOff[3].execute();

		remote.setCommand(4, ceilingFanOnCommand, ceilingFanOffCommand);
		remote.commandsOn[4].execute();
		remote.commandsOff[4].execute();

		remote.setCommand(5, hottubOnCommand, hottubOffCommand);
		remote.commandsOn[5].execute();
		remote.commandsOff[5].execute();

		remote.setCommand(6, garageLightOnCommand, gaLightOffCommand);
		remote.commandsOn[6].execute();
		remote.commandsOff[6].execute();

		remote.setCommand(7, garageDoorOpenCommand, garageDoorCloseCommand);
		remote.commandsOn[7].execute();
		remote.commandsOff[7].execute();

		System.out.println(remote.toString());

	}
}
