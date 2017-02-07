package f1.RemoteControl.CommandPattern;

public class RemoteControlTestWithUndo {

	public static void main(String[] args) {
		RemoteControlWithUndo remote = new RemoteControlWithUndo();

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

		CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
		CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);

		remote.setCommand(0, livingRoomLightOnCommand, lightOffCommand);
		remote.setCommand(1, stereoOn, stereoOff);
		remote.setCommand(2, tvOnCommand, tvOffCommand);
		remote.setCommand(3, kitchenLightOnCommand, kiLightOffCommand);
		remote.setCommand(4, ceilingFanOnCommand, ceilingFanOffCommand);
		remote.setCommand(5, hottubOnCommand, hottubOffCommand);
		remote.setCommand(6, garageLightOnCommand, gaLightOffCommand);
		remote.setCommand(7, garageDoorOpenCommand, garageDoorCloseCommand);
		remote.setCommand(8, ceilingFanHighCommand, ceilingFanOffCommand);
		remote.setCommand(9, ceilingFanMediumCommand, ceilingFanOffCommand);
		System.out.println(remote.toString());

		remote.onButtonWasPushed(0);
		remote.offButtonWasPushed(0);
		remote.undoCommnadWasPushed();

		remote.onButtonWasPushed(1);
		remote.undoCommnadWasPushed();
		remote.offButtonWasPushed(1);

		remote.onButtonWasPushed(2);
		remote.offButtonWasPushed(2);

		remote.onButtonWasPushed(3);
		remote.offButtonWasPushed(3);

		remote.onButtonWasPushed(4);
		remote.offButtonWasPushed(4);

		remote.onButtonWasPushed(5);
		remote.offButtonWasPushed(5);

		remote.onButtonWasPushed(6);
		remote.offButtonWasPushed(6);

		remote.onButtonWasPushed(7);
		remote.offButtonWasPushed(7);

		remote.onButtonWasPushed(8);
		remote.onButtonWasPushed(9);
		remote.undoCommnadWasPushed();
		remote.offButtonWasPushed(8);

	}
}
