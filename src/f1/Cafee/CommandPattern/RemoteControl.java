package f1.Cafee.CommandPattern;

public class RemoteControl {

	Command[] commandsOn;
	Command[] commandsOff;

	public RemoteControl() {
		commandsOn = new Command[8];
		commandsOff = new Command[8];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 8; i++) {
			commandsOn[i] = noCommand;
			commandsOff[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command commandOn, Command commandOff) {
		commandsOn[slot] = commandOn;
		commandsOff[slot] = commandOff;
	}

	public void onButtonWasPushed(int slot) {
		commandsOn[slot].execute();
	}

	public void offButtonWasPushed(int slot) {
		commandsOff[slot].execute();
	}

	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------RemoteControl------\n");
		for (int i = 0; i < commandsOn.length; i++) {
			stringBuff.append("[slot " + i + "] " + commandsOn[i].getClass().getSimpleName() + "\n         "
					+ commandsOff[i].getClass().getSimpleName() + "\n\n");
		}
		return stringBuff.toString();
	}
}
