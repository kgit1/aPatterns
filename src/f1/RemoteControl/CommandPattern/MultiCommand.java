package f1.RemoteControl.CommandPattern;

import java.util.Arrays;

public class MultiCommand implements Command {

	Command[] commands;

	public MultiCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].execute();
		}

	}

	@Override
	public void undo() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].undo();
		}
	}

	@Override
	public String toString() {
		return "MultiCommand [commands=" + Arrays.toString(commands) + "]";
	}

}
