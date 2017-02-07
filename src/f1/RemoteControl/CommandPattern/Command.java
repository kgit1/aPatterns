package f1.RemoteControl.CommandPattern;

//generic interface for all commands
public interface Command {
	// execute method of command object
	void execute();

	// undo last method of command object
	void undo();
}
