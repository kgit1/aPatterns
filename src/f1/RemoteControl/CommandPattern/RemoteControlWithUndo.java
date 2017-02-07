package f1.RemoteControl.CommandPattern;

public class RemoteControlWithUndo {

	Command[] commandsOn;
	Command[] commandsOff;
	Command undoCommand;

	public RemoteControlWithUndo() {
		commandsOn = new Command[11];
		commandsOff = new Command[11];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 11; i++) {
			commandsOn[i] = noCommand;
			commandsOff[i] = noCommand;
		}
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command commandOn, Command commandOff) {
		commandsOn[slot] = commandOn;
		commandsOff[slot] = commandOff;
	}

	public void onButtonWasPushed(int slot) {
		commandsOn[slot].execute();
		undoCommand = commandsOn[slot];
	}

	public void offButtonWasPushed(int slot) {
		commandsOff[slot].execute();
		undoCommand = commandsOff[slot];
	}

	public void undoCommandWasPushed() {
		undoCommand.undo();
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
